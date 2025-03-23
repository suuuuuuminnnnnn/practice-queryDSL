package practice.querydsl.productOrderSystem.domain.order.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.querydsl.productOrderSystem.domain.order.application.useCase.CancelOrderUseCase;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;

@Service
@RequiredArgsConstructor
public class CancelOrderService implements CancelOrderUseCase {

    private final OrderPersistencePort orderPersistencePort;

    @Override
    @Transactional
    public void execute(Long orderId) {
        Order order = orderPersistencePort.findByOrderId(orderId);
        orderPersistencePort.deleteOrder(order);
    }
}
