package practice.querydsl.productOrderSystem.domain.cart.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;

@Entity
@Data
@Table(name = "cart_item")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CartItemJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart")
    private CartJpaEntity cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_product")
    private ProductJpaEntity product;

    private Long quantity;
}
