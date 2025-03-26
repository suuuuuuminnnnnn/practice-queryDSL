package practice.querydsl.productOrderSystem.domain.review.application.port;

import org.springframework.data.domain.Pageable;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;

import java.util.List;

public interface ReviewApplicationPort {
    void createReview(String title, String content, Long productId, Long orderId);

    List<GetReviewResponse> searchReviews(Long productId, Long userId, Long orderId, Pageable pageable);

    void deleteReview(Long productId);
}
