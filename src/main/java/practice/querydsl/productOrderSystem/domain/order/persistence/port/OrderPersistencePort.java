package practice.querydsl.productOrderSystem.domain.order.persistence.port;

import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.util.List;

public interface OrderPersistencePort {
    void saveOrder(Order order);

    List<GetOrderResponse> findAllOrders(UserJpaEntity user);
}
