package practice.querydsl.productOrderSystem.domain.review.presentation.data.response;

import lombok.Builder;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Builder
public record GetReviewResponse(
        String title,
        String content,
        Product product
) {
}
