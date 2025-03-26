package practice.querydsl.productOrderSystem.domain.review.presentation.data.request;

public record CreateReviewRequest(
        String title,
        String content,
        Long productId,
        Long orderId
) {
}
