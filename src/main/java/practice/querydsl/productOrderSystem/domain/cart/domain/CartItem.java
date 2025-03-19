package practice.querydsl.productOrderSystem.domain.cart.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Getter
@Builder
public class CartItem {
    private final Long id;
    private final Cart cart;
    private final Product product;
    private final Long quantity;
}
