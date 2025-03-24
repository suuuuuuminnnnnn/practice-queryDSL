package practice.querydsl.productOrderSystem.domain.product.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.business.persistence.entity.BusinessJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String name;
    private Long price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_business")
    private BusinessJpaEntity business;

    @ManyToOne
    @JoinColumn(name = "product_user")
    private UserJpaEntity user;

    public ProductJpaEntity(Long id) {
        this.id = id;
    }
}
