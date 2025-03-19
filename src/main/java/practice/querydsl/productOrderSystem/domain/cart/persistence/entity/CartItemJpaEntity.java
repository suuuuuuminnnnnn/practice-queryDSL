package practice.querydsl.productOrderSystem.domain.cart.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;

@Entity
@Getter
@Table(name = "cart_item")
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "cart_item_id", nullable = false))
public class CartItemJpaEntity extends BaseIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart")
    private CartJpaEntity cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_product")
    private ProductJpaEntity product;

    private Long productQuantity;
}
