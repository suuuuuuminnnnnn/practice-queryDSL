package practice.querydsl.productOrderSystem.domain.wishlist.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

@Getter
@Builder
public class Wishlist {
    private Long id;
    private Product product;
    private User user;
}
