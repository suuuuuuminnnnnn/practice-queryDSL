package practice.querydsl.productOrderSystem.domain.review.persistence.adapter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.mapper.OrderMapper;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.review.domain.Review;
import practice.querydsl.productOrderSystem.domain.review.persistence.entity.ReviewJpaEntity;
import practice.querydsl.productOrderSystem.domain.review.persistence.mapper.ReviewMapper;
import practice.querydsl.productOrderSystem.domain.review.persistence.port.ReviewPersistencePort;
import practice.querydsl.productOrderSystem.domain.review.persistence.repository.ReviewJpaRepository;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.List;

import static practice.querydsl.productOrderSystem.domain.review.persistence.entity.QReviewJpaEntity.reviewJpaEntity;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class ReviewPersistenceAdapter implements ReviewPersistencePort {

    private final JPAQueryFactory queryFactory;
    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewMapper reviewMapper;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    public void saveReview(Review review) {
        reviewJpaRepository.save(reviewMapper.toEntity(review));
    }

    public List<GetReviewResponse> searchReviews(Product product, UserJpaEntity user, Order order, Pageable pageable) {
        return queryFactory
                .selectFrom(reviewJpaEntity)
                .where(
                        productEq(product),
                        userEq(user),
                        orderEq(order)
                )
                .orderBy(reviewJpaEntity.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .stream()
                .map(reviewMapper::toResponse)
                .toList();
    }

    public void deleteReview(Long reviewId) {
        reviewJpaRepository.deleteById(reviewId);
    }

    public Review findReviewByProductAndUser(Product product, UserJpaEntity user) {
        ReviewJpaEntity entity = queryFactory
                .selectFrom(reviewJpaEntity)
                .where(reviewJpaEntity.product.eq(productMapper.toEntity(product))
                        .and(reviewJpaEntity.user.eq(user)))
                .fetchOne();
        return reviewMapper.toDomain(entity);
    }

    private BooleanExpression productEq(Product product) {
        return product != null ? reviewJpaEntity.product.eq(productMapper.toEntity(product)) : null;
    }

    private BooleanExpression userEq(UserJpaEntity user) {
        return user != null ? reviewJpaEntity.user.eq(user) : null;
    }

    private BooleanExpression orderEq(Order order) {
        return order != null ? reviewJpaEntity.order.eq(orderMapper.toEntity(order)) : null;
    }

}
