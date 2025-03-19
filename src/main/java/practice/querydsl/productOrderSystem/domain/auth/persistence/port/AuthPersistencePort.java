package practice.querydsl.productOrderSystem.domain.auth.persistence.port;

import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;

public interface AuthPersistencePort {
    void saveRefreshToken(RefreshToken refreshToken);
}
