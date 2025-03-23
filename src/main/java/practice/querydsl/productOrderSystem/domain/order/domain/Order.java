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

    private Long id;
    private OrderStatus status;
    private Product product;
    private Long quantity;
    private Review review;
    private User user;
}