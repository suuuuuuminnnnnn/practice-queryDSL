package practice.querydsl.productOrderSystem.domain.auth.persistence.port;

import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

public interface AuthPersistencePort {
    void saveUser(UserJpaEntity user);

    boolean existsRefreshTokenByUserId(Long userId);

    RefreshToken findRefreshTokenByRefreshToken(String refreshToken);

    void saveRefreshToken(RefreshToken refreshToken);
}
