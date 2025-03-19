package practice.querydsl.productOrderSystem.domain.review.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.persistence.entity.OrderJpaEntity;

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
