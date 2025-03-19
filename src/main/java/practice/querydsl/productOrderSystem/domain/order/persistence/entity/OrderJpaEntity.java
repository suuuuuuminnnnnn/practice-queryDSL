package practice.querydsl.productOrderSystem.domain.order.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.review.persistence.entity.ReviewJpaEntity;

@Getter
@Entity
@Table(name = "orders")
@AttributeOverride(name = "id", column = @Column(name = "order_id", nullable = false))
@NoArgsConstructor
public class OrderJpaEntity extends BaseIdEntity {

    @ManyToOne
    private ProductJpaEntity product;

    private OrderStatus orderStatus;

    private Long productQuantity;

    @OneToOne
    private ReviewJpaEntity review;

    @ManyToOne
    private UserJpaEntity user;
}
