package practice.querydsl.productOrderSystem.domain.order.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.review.persistence.mapper.ReviewMapper;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductMapper productMapper;
    private final UserMapper userMapper;
    private final ReviewMapper reviewMapper;

    public Order toDomain(OrderJpaEntity orderJpaEntity) {
        return Order.builder()
                .id(orderJpaEntity.getId())
                .status(orderJpaEntity.getStatus())
                .product(productMapper.toDomain(orderJpaEntity.getProduct()))
                .quantity(orderJpaEntity.getQuantity())
                .review(orderJpaEntity.getReview() != null ? reviewMapper.toDomain(orderJpaEntity.getReview()) : null)
                .user(userMapper.toDomain(orderJpaEntity.getUser()))
                .build();
    }

    public OrderJpaEntity toEntity(Order order) {
        return OrderJpaEntity.builder()
                .id(order.getId())
                .status(order.getStatus())
                .product(productMapper.toEntity(order.getProduct()))
                .quantity(order.getQuantity())
                .review(order.getReview() != null ? reviewMapper.toEntity(order.getReview()) : null)
                .user(userMapper.toEntity(order.getUser()))
                .build();
    }

    public GetOrderResponse toResponse(Order order) {
        Product product = order.getProduct();
        return GetOrderResponse.builder()
                .id(order.getId())
                .product(GetOrderResponse.ProductResponse.builder()
                        .id(product.getId())
                        .category(String.valueOf(product.getCategory()))
                        .name(product.getName())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .businessName(product.getBusiness() != null ? product.getBusiness().getName() : null)
                        .build())
                .quantity(order.getQuantity())
                .price(product.getPrice())
                .totalPrice(product.getPrice() * order.getQuantity())
                .build();
    }
}
