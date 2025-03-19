package practice.querydsl.productOrderSystem.domain.user.persistence.port;

public interface UserPersistencePort {
   Long findMoneyByUserId(Long userId);
}
