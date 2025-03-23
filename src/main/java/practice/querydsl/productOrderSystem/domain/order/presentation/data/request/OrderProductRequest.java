package practice.querydsl.productOrderSystem.domain.order.presentation.data.request;

import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;

public record OrderProductRequest(
        Long productId,
        Long quantity,
        OrderStatus status
) {
}
