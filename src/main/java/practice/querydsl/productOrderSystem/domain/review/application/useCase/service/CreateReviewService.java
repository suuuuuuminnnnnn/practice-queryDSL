package practice.querydsl.productOrderSystem.domain.review.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.review.application.useCase.CreateReviewUseCase;
import practice.querydsl.productOrderSystem.domain.review.domain.Review;
import practice.querydsl.productOrderSystem.domain.review.persistence.port.ReviewPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;
import practice.querydsl.productOrderSystem.global.exception.CustomException;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateReviewService implements CreateReviewUseCase {

    private final ReviewPersistencePort reviewPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final OrderPersistencePort orderPersistencePort;
    private final UserUtil userUtil;
    private final UserMapper userMapper;

    public void execute(String title, String content, Long productId, Long orderId) {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();
        Product product = productPersistencePort.findProductByProductId(productId);
        Order order = orderPersistencePort.findByOrderId(orderId)
                .orElseThrow(() -> new CustomException("주문을 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        LocalDateTime date = LocalDateTime.now();

        Review review = Review.builder()
                .title(title)
                .content(content)
                .createdAt(date)
                .product(product)
                .author(userMapper.toDomain(userJpaEntity))
                .order(order)
                .build();
        reviewPersistencePort.saveReview(review);
    }
}
