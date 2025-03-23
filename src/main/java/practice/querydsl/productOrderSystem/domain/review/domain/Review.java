package practice.querydsl.productOrderSystem.domain.review.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;

@Getter
@Builder
public class Review {
    private Long id;
    private String title;
    private String content;
    private Product product;
    private User author;
    private Order order;
}
