package practice.querydsl.productOrderSystem.domain.review.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "review")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReviewJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "review_product")
    private ProductJpaEntity product;

    @ManyToOne
    @JoinColumn(name = "review_user")
    private UserJpaEntity user;

    @ManyToOne
    @JoinColumn(name = "review_order")
    private OrderJpaEntity order;
}
