package practice.querydsl.productOrderSystem.domain.user.persistence.port;

import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

public interface UserPersistencePort {
   Long findMoneyByUserId(Long userId);

   UserJpaEntity findUserByEmail(String email);
}
