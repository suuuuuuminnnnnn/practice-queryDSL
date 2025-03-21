package practice.querydsl.productOrderSystem.domain.auth.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.SignInUseCase;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.auth.persistence.repository.RefreshTokenJpaRepository;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.persistence.repository.UserJpaRepository;
import practice.querydsl.productOrderSystem.global.exception.CustomException;
import practice.querydsl.productOrderSystem.global.security.jwt.TokenProvider;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class SignInService implements SignInUseCase {

    private final RefreshTokenJpaRepository refreshTokenJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final UserPersistencePort userPersistencePort;

    @Override
    @Transactional
    public TokenDto execute(String email, String password) {
        UserJpaEntity userJpaEntity = userPersistencePort.findUserByEmail(email);
        if (!passwordEncoder.matches(password, userJpaEntity.getPassword())) {
            throw new CustomException("비밀번호가 틀렸습니다.", HttpStatus.BAD_REQUEST);
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

        return tokenDto;
    }
}
