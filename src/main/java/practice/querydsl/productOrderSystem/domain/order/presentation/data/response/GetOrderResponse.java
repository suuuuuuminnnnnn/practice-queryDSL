package practice.querydsl.productOrderSystem.domain.order.presentation.data.response;

import lombok.Builder;

@Builder
public record GetOrderResponse(
        Long id,
        ProductResponse product,
        Long quantity,
        Long price,
        Long totalPrice
) {
    @Builder
    public record ProductResponse(
            Long id,
            String category,
            String name,
            Long price,
            String description,
            String businessName
    ) {
    }
}