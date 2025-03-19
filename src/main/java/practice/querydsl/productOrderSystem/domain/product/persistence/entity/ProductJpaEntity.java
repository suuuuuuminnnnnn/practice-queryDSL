package practice.querydsl.productOrderSystem.domain.product.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.business.persistence.entity.BusinessJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;

@Getter
@Entity
@Table(name = "product")
@AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
@NoArgsConstructor
public class ProductJpaEntity extends BaseIdEntity {

    private ProductCategory productCategory;
    private String productName;
    private Long productPrice;
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "product_business")
    private BusinessJpaEntity business;

    @ManyToOne
    @JoinColumn(name = "product_user")
    private UserJpaEntity user;
}
