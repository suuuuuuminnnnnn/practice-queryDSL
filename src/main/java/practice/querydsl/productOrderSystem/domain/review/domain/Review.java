package practice.querydsl.productOrderSystem.domain.review.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

import java.time.LocalDateTime;

@Getter
@Builder
public class Review {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Product product;
    private User author;
    private Order order;
}
