package practice.querydsl.productOrderSystem.domain.review.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;

@Getter
@Builder
public class Review {
    Long reviewId;
    String reviewTitle;
    String reviewContent;
    Product product;
    User author;
    Order order;
}
