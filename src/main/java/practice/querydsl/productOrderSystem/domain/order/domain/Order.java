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

    Long orderId;
    OrderStatus orderStatus;
    Product product;
    Long productQuantity;
    Review review;
    User user;
}