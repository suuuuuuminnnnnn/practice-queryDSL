package practice.querydsl.productOrderSystem.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;

@Getter
@Builder
public class User {
    private final Long userId;
    private final String email;
    private final String password;
    private final Long money;
    private final UserRole role;
}
