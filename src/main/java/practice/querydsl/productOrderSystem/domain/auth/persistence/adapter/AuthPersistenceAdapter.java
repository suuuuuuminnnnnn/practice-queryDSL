package practice.querydsl.productOrderSystem.domain.auth.persistence.adapter;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.auth.persistence.port.AuthPersistencePort;
import practice.querydsl.productOrderSystem.domain.auth.persistence.repository.RefreshTokenJpaRepository;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements AuthPersistencePort {

    private final RefreshTokenJpaRepository refreshTokenJpaRepository;

    @Override
    public void saveRefreshToken(RefreshToken refreshToken) {
        refreshTokenJpaRepository.save(refreshToken);
    }
}
