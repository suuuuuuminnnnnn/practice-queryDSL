package practice.querydsl.productOrderSystem.domain.order.presentation.data.response;

import lombok.Builder;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Builder
public record GetOrderResponse(
        Long id,
        Product product,
        Long quantity,
        Long price
) {
}
