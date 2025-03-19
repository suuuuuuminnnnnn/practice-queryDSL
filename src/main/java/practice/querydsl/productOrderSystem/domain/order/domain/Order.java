package practice.querydsl.productOrderSystem.domain.order.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.review.domain.Review;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Getter
@Builder
public class Order {

    private final Long id;
    private final OrderStatus status;
    private final Product product;
    private final Long quantity;
    private final Review review;
    private final User user;
}