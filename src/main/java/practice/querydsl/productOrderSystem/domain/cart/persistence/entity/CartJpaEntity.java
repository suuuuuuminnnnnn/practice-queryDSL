package practice.querydsl.productOrderSystem.domain.cart.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.util.List;

@Getter
@Entity
@Table(name = "cart")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CartJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<CartItemJpaEntity> cartItems;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_user")
    private UserJpaEntity user;
}
