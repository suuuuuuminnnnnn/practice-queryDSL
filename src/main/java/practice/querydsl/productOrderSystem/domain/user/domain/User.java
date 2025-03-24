package practice.querydsl.productOrderSystem.domain.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;

@Getter
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
    private Long money;
    private UserRole role;

    public User(Long id) {
        this.id = id;
    }
}
