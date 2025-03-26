package practice.querydsl.productOrderSystem.domain.review.application.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import practice.querydsl.productOrderSystem.domain.review.application.port.ReviewApplicationPort;
import practice.querydsl.productOrderSystem.domain.review.application.useCase.CreateReviewUseCase;
import practice.querydsl.productOrderSystem.domain.review.application.useCase.DeleteReviewUseCase;
import practice.querydsl.productOrderSystem.domain.review.application.useCase.SearchReviewsUseCase;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.List;

@Adapter(AdapterType.INBOUND)
@RequiredArgsConstructor
public class ReviewApplicationAdapter implements ReviewApplicationPort {

    private final CreateReviewUseCase createReviewUseCase;
    private final DeleteReviewUseCase deleteReviewUseCase;
    private final SearchReviewsUseCase searchReviewsUseCase;

    @Override
    public void createReview(String title, String content, Long productId, Long orderId) {
        createReviewUseCase.execute(title, content, productId, orderId);
    }

    @Override
    public List<GetReviewResponse> searchReviews(Long productId, Long userId, Long orderId, Pageable pageable) {
        return searchReviewsUseCase.execute(productId, userId, orderId, pageable);
    }

    @Override
    public void deleteReview(Long productId) {
        deleteReviewUseCase.execute(productId);
    }
}
