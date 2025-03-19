package practice.querydsl.productOrderSystem.domain.wishlist.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

@Entity
@Getter
@Table(name = "wishlist",
uniqueConstraints = @UniqueConstraint(columnNames = {"wishlist_product", "wishlist_user"}))
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WishlistJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wishlist_product")
    private ProductJpaEntity product;

    @ManyToOne
    @JoinColumn(name = "wishlist_user")
    private UserJpaEntity user;
}
