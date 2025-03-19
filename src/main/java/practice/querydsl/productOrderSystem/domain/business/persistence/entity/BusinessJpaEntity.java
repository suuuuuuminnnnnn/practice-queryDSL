package practice.querydsl.productOrderSystem.domain.business.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;

@Getter
@Entity
@Table(name = "business")
@AttributeOverride(name = "id", column = @Column(name = "business_id", nullable = false))
@NoArgsConstructor
public class BusinessJpaEntity extends BaseIdEntity {

    private String businessName;
    private String businessDescription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "business_user",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private UserJpaEntity user;
}
