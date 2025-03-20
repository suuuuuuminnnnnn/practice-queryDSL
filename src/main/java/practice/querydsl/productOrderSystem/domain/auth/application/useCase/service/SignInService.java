package practice.querydsl.productOrderSystem.domain.auth.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.SignInUseCase;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.auth.persistence.repository.RefreshTokenJpaRepository;
import practice.querydsl.productOrderSystem.domain.auth.presentation.data.SignInResponse;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.global.security.jwt.TokenProvider;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class SignInService implements SignInUseCase {

    private final RefreshTokenJpaRepository refreshTokenJpaRepository;
    private final UserPersistencePort userPersistencePort;
    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Override
    public SignInResponse execute(String email, String password) {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();
        if (!passwordEncoder.matches(password, userJpaEntity.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }
        TokenDto tokenDto = tokenProvider.generateToken(userJpaEntity.getId());
        if (tokenDto.getRefreshToken() == null || tokenDto.getRefreshTokenExpAt() == null) {
            throw new RuntimeException("만료된 리프레쉬 토큰 입니다.");
        }
        RefreshToken refreshToken = RefreshToken.builder()
                .userId(userJpaEntity.getId())
                .token(tokenDto.getRefreshToken())
                .expTime(tokenDto.getRefreshTokenExpAt())
                .build();
        refreshTokenJpaRepository.save(refreshToken);

        return new SignInResponse(tokenDto);
    }
}
