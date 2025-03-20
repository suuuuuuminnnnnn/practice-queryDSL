package practice.querydsl.productOrderSystem.domain.auth.application.useCase;

import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;

public interface SignUpUseCase {
    void execute(String email, String password, UserRole role);
}
