package practice.querydsl.productOrderSystem.domain.order.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.review.persistence.entity.ReviewJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProductJpaEntity product;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Long quantity;

    @OneToOne
    private ReviewJpaEntity review;

    @ManyToOne
    private UserJpaEntity user;
}
