package practice.querydsl.productOrderSystem.domain.review.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;

@Getter
@Builder
public class Review {
    private final Long id;
    private final String title;
    private final String content;
    private final Product product;
    private final User author;
    private final Order order;
}
