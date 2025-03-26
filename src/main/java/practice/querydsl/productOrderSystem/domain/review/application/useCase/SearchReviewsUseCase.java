package practice.querydsl.productOrderSystem.domain.review.application.useCase;

import org.springframework.data.domain.Pageable;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;

import java.util.List;

public interface SearchReviewsUseCase {
    List<GetReviewResponse> execute(Long productId, Long userId, Long orderId, Pageable pageable);
}
