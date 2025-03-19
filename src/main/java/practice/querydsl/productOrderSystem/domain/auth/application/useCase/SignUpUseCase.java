package practice.querydsl.productOrderSystem.domain.auth.application.useCase;

public interface SignUpUseCase {
    void execute(String email, String password);
}
