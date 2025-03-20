package practice.querydsl.productOrderSystem.domain.auth.presentation.data.request;

public record SignInRequest(
        String email,
        String password
) {
}
