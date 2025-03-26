package practice.querydsl.productOrderSystem.domain.order.presentation.data.response;

import lombok.Builder;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

@Builder
public record GetOrderResponse(
        Long id,
        ProductResponse product,
        Long quantity,
        Long totalPrice
) {
    @Builder
    public record ProductResponse(
            Long id,
            ProductCategory category,
            String name,
            Long price,
            String description,
            String businessName
    ) {
    }
}