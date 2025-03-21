package practice.querydsl.productOrderSystem.domain.order.presentation.data.response;

import practice.querydsl.productOrderSystem.domain.product.domain.Product;

public record GetOrderResponse(
        Long id,
        Product product,
        Long quantity,
        Long price
) {
}
