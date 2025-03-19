package practice.querydsl.productOrderSystem.domain.cart.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

import java.util.List;

@Getter
@Builder
public class Cart {
    Long cartId;
    List<CartItem> cartItems;
    User user;
}
