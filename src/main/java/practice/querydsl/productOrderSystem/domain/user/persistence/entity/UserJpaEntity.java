package practice.querydsl.productOrderSystem.domain.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Long money;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public void addMoney(Long money) {
        this.money += money;
    }

    public void removeMoney(Long money) {
        this.money -= money;
    }
}

