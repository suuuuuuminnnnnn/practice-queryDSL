package practice.querydsl.productOrderSystem.domain.review.persistence.port;

import org.springframework.data.domain.Pageable;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.review.domain.Review;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.util.List;

public interface ReviewPersistencePort {
    void saveReview(Review review);

    List<GetReviewResponse> searchReviews(Product product, UserJpaEntity user, Order order, Pageable pageable);

    void deleteReview(Long reviewId);

    Review findReviewByProductAndUser(Product product, UserJpaEntity user);
}
