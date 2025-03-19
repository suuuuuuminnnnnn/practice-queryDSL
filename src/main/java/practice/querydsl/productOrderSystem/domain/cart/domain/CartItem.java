package practice.querydsl.productOrderSystem.domain.cart.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Getter
@Builder
public class CartItem {
    private final Long cartItemId;
    private final Cart cart;
    private final Product product;
    private final Long productQuantity;
}
