package practice.querydsl.productOrderSystem.domain.user.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

@Repository
public interface UserJpaRepository extends CrudRepository<UserJpaEntity, Long> {
}
