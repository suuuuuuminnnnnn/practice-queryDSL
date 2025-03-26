package practice.querydsl.productOrderSystem.domain.review.application.useCase;

public interface CreateReviewUseCase {
    void execute(String title, String content, Long productId, Long orderId);
}
