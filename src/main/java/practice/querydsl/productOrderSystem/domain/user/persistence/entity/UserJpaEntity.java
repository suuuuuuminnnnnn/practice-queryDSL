package practice.querydsl.productOrderSystem.domain.user.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;
import practice.querydsl.productOrderSystem.global.entity.BaseIdEntity;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserJpaEntity extends BaseIdEntity {

    private String email;
    private String password;
    private Long money;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
