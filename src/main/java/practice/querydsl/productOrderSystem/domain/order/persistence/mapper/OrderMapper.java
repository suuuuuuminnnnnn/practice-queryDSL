package practice.querydsl.productOrderSystem.domain.order.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public Order toDomain(OrderJpaEntity orderJpaEntity) {
        return Order.builder()
                .id(orderJpaEntity.getId())
                .status(orderJpaEntity.getStatus())
                .product(productMapper.toDomain(orderJpaEntity.getProduct()))
                .quantity(orderJpaEntity.getQuantity())
                .review(orderJpaEntity.getReview())
                .user(userMapper.toDomain(orderJpaEntity.getUser()))
                .build();
    }

    public OrderJpaEntity toEntity(Order order) {
        return OrderJpaEntity.builder()
                .id(order.getId())
                .status(order.getStatus())
                .product(productMapper.toEntity(order.getProduct()))
                .quantity(order.getQuantity())
                .review(order.getReview())
                .user(userMapper.toEntity(order.getUser()))
                .build();

    }
}
