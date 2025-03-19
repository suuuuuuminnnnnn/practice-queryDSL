package practice.querydsl.productOrderSystem.domain.auth.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;

public interface RefreshTokenJpaRepository extends CrudRepository<RefreshToken, Long> {
    boolean existsByRefreshToken(String refreshToken);
    RefreshToken findByToken(String token);
}
