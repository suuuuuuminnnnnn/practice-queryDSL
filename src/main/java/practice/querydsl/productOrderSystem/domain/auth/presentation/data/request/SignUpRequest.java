package practice.querydsl.productOrderSystem.domain.auth.presentation.data.request;

import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;

public record SignUpRequest(
        String email,
        String password,
        UserRole role
) {
}
