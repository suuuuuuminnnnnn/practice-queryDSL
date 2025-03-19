package practice.querydsl.productOrderSystem.domain.wishlist.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;

@Entity
@Getter
@Table(name = "wishlist",
uniqueConstraints = @UniqueConstraint(columnNames = {"wishlist_product", "wishlist_user"}))
@AttributeOverride(name = "id", column = @Column(name = "wishlist_id", nullable = false))
@NoArgsConstructor
public class WishlistJpaEntity extends BaseIdEntity {

    @ManyToOne
    @JoinColumn(name = "wishlist_product")
    private ProductJpaEntity product;

    @ManyToOne
    @JoinColumn(name = "wishlist_user")
    private UserJpaEntity user;
}
