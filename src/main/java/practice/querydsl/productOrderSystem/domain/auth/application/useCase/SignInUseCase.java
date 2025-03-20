package practice.querydsl.productOrderSystem.domain.auth.application.useCase;

import practice.querydsl.productOrderSystem.domain.auth.presentation.data.response.SignInResponse;

public interface SignInUseCase {
    SignInResponse execute(String email, String password);
}
