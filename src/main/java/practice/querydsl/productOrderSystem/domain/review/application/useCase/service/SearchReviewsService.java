package practice.querydsl.productOrderSystem.domain.review.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.review.application.useCase.SearchReviewsUseCase;
import practice.querydsl.productOrderSystem.domain.review.persistence.port.ReviewPersistencePort;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.exception.CustomException;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchReviewsService implements SearchReviewsUseCase {

    private final ReviewPersistencePort reviewPersistencePort;
    private final OrderPersistencePort orderPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final UserUtil userUtil;

    public List<GetReviewResponse> execute(Long productId, Long userId, Long orderId, Pageable pageable) {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();
        Order order = orderPersistencePort.findByOrderId(orderId)
                .orElseThrow(() -> new CustomException("해당 주문을 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        Product product = productPersistencePort.findProductByProductId(productId);

        return reviewPersistencePort.searchReviews(product, userJpaEntity, order, pageable);
    }
}
