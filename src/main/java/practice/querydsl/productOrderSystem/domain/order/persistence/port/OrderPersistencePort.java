package practice.querydsl.productOrderSystem.domain.order.persistence.port;

import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.util.List;

public interface OrderPersistencePort {
    void saveOrder(OrderJpaEntity order);

    List<Order> findOrdersByUserIdAndStatusIn(UserJpaEntity user);

    void deleteOrder(OrderJpaEntity order);
}
