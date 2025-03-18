package practice.querydsl.productOrderSystem.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;

@Getter
@Builder
public class User {
    private Long userId;
    private String email;
    private String password;
    private UserRole role;
}
