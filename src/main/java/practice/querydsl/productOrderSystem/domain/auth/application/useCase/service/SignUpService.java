package practice.querydsl.productOrderSystem.domain.auth.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.SignUpUseCase;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUseCase {

    @Override
    public void execute(String email, String password) {

    }
}
