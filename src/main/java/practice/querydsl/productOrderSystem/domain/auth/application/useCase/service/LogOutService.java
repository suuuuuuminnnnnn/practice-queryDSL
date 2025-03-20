package practice.querydsl.productOrderSystem.domain.auth.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.LogOutUseCase;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.auth.persistence.repository.RefreshTokenJpaRepository;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.global.redis.util.RedisUtil;
import practice.querydsl.productOrderSystem.global.security.jwt.TokenProvider;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class LogOutService implements LogOutUseCase {

    private final RedisUtil redisUtil;
    private final UserUtil userUtil;
    private final RefreshTokenJpaRepository refreshTokenJpaRepository;
    private final TokenProvider tokenProvider;
    private final UserPersistencePort userPersistencePort;

    @Override
    public void execute(String token) {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("토큰이 비어있습니다.");
        }

        String accessToken = tokenProvider.removePrefix(token);
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();

        if (!userPersistencePort.existsUserByUserId(userJpaEntity.getId())) {
            throw new RuntimeException("유저를 찾을 수 없습니다.");
        }

        RefreshToken refreshToken = refreshTokenJpaRepository.findById(userJpaEntity.getId())
                .orElseThrow(() -> new RuntimeException("리프레시 토큰을 찾을 수 없습니다."));

        refreshTokenJpaRepository.delete(refreshToken);

        long exp = tokenProvider.getExpiration(accessToken);
        redisUtil.setBlackList(accessToken, "access_token", exp);
    }
}
