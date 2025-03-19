package practice.querydsl.productOrderSystem.domain.user.persistence.port;

import practice.querydsl.productOrderSystem.domain.user.domain.User;

import java.util.Optional;

public interface UserPersistencePort {
    Optional<User> findUserByUserId(Long userId);
}
