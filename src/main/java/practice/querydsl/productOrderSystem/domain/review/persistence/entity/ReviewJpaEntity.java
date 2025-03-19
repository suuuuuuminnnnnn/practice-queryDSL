package practice.querydsl.productOrderSystem.domain.review.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;

@Getter
@Entity
@Table(name = "review")
@AttributeOverride(name = "id", column = @Column(name = "review_id", nullable = false))
@NoArgsConstructor
public class ReviewJpaEntity extends BaseIdEntity {

    private String reviewTitle;

    @ManyToOne
    @JoinColumn(name = "review_product")
    private ReviewJpaEntity review;

    @ManyToOne
    @JoinColumn(name = "review_user")
    private ReviewJpaEntity user;

    @ManyToOne
    @JoinColumn(name = "review_order")
    private OrderJpaEntity order;
}
