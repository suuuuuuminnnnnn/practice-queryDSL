package practice.querydsl.productOrderSystem.domain.cart.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.cart.persistence.entity.CartItemJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;

import java.util.List;

@Getter
@Entity
@Table(name = "cart")
@AttributeOverride(name = "id", column = @Column(name = "cart_id", nullable = false))
@NoArgsConstructor
public class CartJpaEntity extends BaseIdEntity {

    @OneToMany
    private List<CartItemJpaEntity> cartItems;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "cart_user",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private UserJpaEntity user;
}
