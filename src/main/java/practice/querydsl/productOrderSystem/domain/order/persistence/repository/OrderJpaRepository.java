package practice.querydsl.productOrderSystem.domain.order.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;

public interface OrderJpaRepository extends CrudRepository<OrderJpaEntity, Long> {
}
