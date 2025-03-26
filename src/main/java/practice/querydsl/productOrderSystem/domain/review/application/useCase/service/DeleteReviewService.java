package practice.querydsl.productOrderSystem.domain.review.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.review.application.useCase.DeleteReviewUseCase;
import practice.querydsl.productOrderSystem.domain.review.domain.Review;
import practice.querydsl.productOrderSystem.domain.review.persistence.port.ReviewPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class DeleteReviewService implements DeleteReviewUseCase {

    private final UserUtil userUtil;
    private final ReviewPersistencePort reviewPersistencePort;
    private final ProductPersistencePort productPersistencePort;

    public void execute(Long productId) {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();
        Product product = productPersistencePort.findProductByProductId(productId);

        Review review = reviewPersistencePort.findReviewByProductAndUser(product, userJpaEntity);

        reviewPersistencePort.deleteReview(review.getId());
    }
}
