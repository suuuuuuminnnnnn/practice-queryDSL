package practice.querydsl.productOrderSystem.domain.order.persistence.adapter;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;
import practice.querydsl.productOrderSystem.domain.order.persistence.repository.OrderJpaRepository;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.List;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public void saveOrder(Order order) {
        orderJpaRepository.save(order);
    }

    @Override
    public List<GetOrderResponse> findAllOrders(UserJpaEntity user) {

    }
}
