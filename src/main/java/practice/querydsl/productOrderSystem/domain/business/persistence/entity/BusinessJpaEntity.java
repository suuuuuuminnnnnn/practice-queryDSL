package practice.querydsl.productOrderSystem.domain.business.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

@Getter
@Entity
@Table(name = "business")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BusinessJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_user")
    private UserJpaEntity user;
}
