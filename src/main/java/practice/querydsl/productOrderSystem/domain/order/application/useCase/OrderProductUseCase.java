package practice.querydsl.productOrderSystem.domain.order.application.useCase;

import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;

public interface OrderProductUseCase {
    void execute(Long productId, Long quantity, OrderStatus status);
}
