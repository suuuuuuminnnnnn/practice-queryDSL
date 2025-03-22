package practice.querydsl.productOrderSystem.domain.cart.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.cart.domain.Cart;
import practice.querydsl.productOrderSystem.domain.cart.domain.CartItem;
import practice.querydsl.productOrderSystem.domain.cart.persistence.entity.CartItemJpaEntity;
import practice.querydsl.productOrderSystem.domain.cart.persistence.entity.CartJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartAggregateMapper {
    private final UserMapper userMapper;
    private final ProductMapper productMapper;

    public Cart toDomain(CartJpaEntity entity) {
        Cart cart = Cart.builder()
                .id(entity.getId())
                .user(userMapper.toDomain(entity.getUser()))
                .build();
        List<CartItem> items = entity.getCartItems().stream()
                .map(item -> CartItem.builder()
                        .id(item.getId())
                        .cart(cart)
                        .product(productMapper.toDomain(item.getProduct()))
                        .quantity(item.getQuantity())
                        .build())
                .collect(Collectors.toList());
        cart.setCartItems(items);
        return cart;
    }

    public CartJpaEntity toEntity(Cart domain) {
        CartJpaEntity entity = CartJpaEntity.builder()
                .id(domain.getId())
                .user(userMapper.toEntity(domain.getUser()))
                .build();
        List<CartItemJpaEntity> items = domain.getCartItems().stream()
                .map(item -> CartItemJpaEntity.builder()
                        .id(item.getId())
                        .cart(entity)
                        .product(productMapper.toEntity(item.getProduct()))
                        .quantity(item.getQuantity())
                        .build())
                .collect(Collectors.toList());
        entity.setCartItems(items);
        return entity;
    }
}