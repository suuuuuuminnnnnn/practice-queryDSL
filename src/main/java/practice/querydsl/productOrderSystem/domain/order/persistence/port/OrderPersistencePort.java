package practice.querydsl.productOrderSystem.domain.order.persistence.port;

import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {
    void saveOrder(Order order);

    List<Order> findOrdersByUserIdAndStatusIn(UserJpaEntity user);

    Optional<Order> findByOrderId(Long orderId);

    void deleteOrder(Order order);
}
