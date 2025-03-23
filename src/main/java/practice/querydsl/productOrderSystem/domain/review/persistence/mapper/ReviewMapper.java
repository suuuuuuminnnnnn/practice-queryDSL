package practice.querydsl.productOrderSystem.domain.review.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.review.domain.Review;
import practice.querydsl.productOrderSystem.domain.review.persistence.entity.ReviewJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class ReviewMapper {
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public Review toDomain(ReviewJpaEntity reviewJpaEntity) {
        return Review.builder()
                .id(reviewJpaEntity.getId())
                .title(reviewJpaEntity.getTitle())
                .content(reviewJpaEntity.getContent())
                .product(productMapper.toDomain(reviewJpaEntity.getProduct()))
                .author(userMapper.toDomain(reviewJpaEntity.getUser()))
                .build();
    }

    public ReviewJpaEntity toEntity(Review review) {
        return ReviewJpaEntity.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .product(productMapper.toEntity(review.getProduct()))
                .user(userMapper.toEntity(review.getAuthor()))
                .build();
    }
}