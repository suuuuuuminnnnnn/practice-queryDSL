package practice.querydsl.productOrderSystem.domain.auth.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.ReissueTokenUseCase;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.auth.persistence.repository.RefreshTokenJpaRepository;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.global.security.jwt.TokenProvider;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

@Service
@RequiredArgsConstructor
public class ReissueTokenService implements ReissueTokenUseCase {

    private final TokenProvider tokenProvider;
    private final RefreshTokenJpaRepository refreshTokenJpaRepository;
    private final UserPersistencePort userPersistencePort;

    @Override
    public TokenDto execute(String token) {
        if (token == null) {
            throw new IllegalArgumentException("토큰이 비어있습니다.");
        }

        String removeToken = tokenProvider.removePrefix(token);
        RefreshToken refreshToken = refreshTokenJpaRepository.findByToken(removeToken);

        Long userId = refreshToken.getUserId();
        if (!userPersistencePort.existsUserByUserId(userId)) {
            throw new IllegalArgumentException("유저가 없습니다.");
        }

        TokenDto tokenDto = tokenProvider.generateToken(userId);
        RefreshToken newRefreshToken = RefreshToken.builder()
                .userId(userId)
                .token(tokenDto.getRefreshToken())
                .expTime(tokenDto.getRefreshTokenExpAt())
                .build();

        refreshTokenJpaRepository.save(newRefreshToken);

        return tokenDto;
    }
}
