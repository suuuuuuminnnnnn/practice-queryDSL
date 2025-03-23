package practice.querydsl.productOrderSystem.domain.cart.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

import java.util.List;

@Getter
@Builder
public class Cart {
    private Long id;
    private  List<CartItem> cartItems;
    private User user;

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
