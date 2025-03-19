package practice.querydsl.productOrderSystem.domain.cart.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Getter
@Builder
public class CartItem {
    Long cartItemId;
    Cart cart;
    Product product;
    Long productQuantity;
}
