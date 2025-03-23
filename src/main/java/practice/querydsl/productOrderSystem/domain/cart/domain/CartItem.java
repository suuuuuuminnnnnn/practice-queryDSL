package practice.querydsl.productOrderSystem.domain.cart.domain;

import lombok.Builder;
import lombok.Data;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;

@Data
@Builder
public class CartItem {
    private Long id;
    private Cart cart;
    private Product product;
    private Long quantity;
}
