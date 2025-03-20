package practice.querydsl.productOrderSystem.domain.auth.application.adapter;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.auth.application.port.AuthApplicationPort;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.LogOutUseCase;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.ReissueTokenUseCase;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.SignInUseCase;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.SignUpUseCase;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

@Adapter(AdapterType.INBOUND)
@RequiredArgsConstructor
public class AuthApplicationAdapter implements AuthApplicationPort {

    private final LogOutUseCase logOutUseCase;
    private final SignInUseCase signInUseCase;
    private final SignUpUseCase signUpUseCase;
    private final ReissueTokenUseCase reissueTokenUseCase;

    @Override
    public void signUp(String email, String password, UserRole role) {
        signUpUseCase.execute(email, password, role);
    }

    @Override
    public TokenDto signIn(String email, String password) {
        return signInUseCase.execute(email, password);
    }

    @Override
    public TokenDto refreshToken(String token) {
        return reissueTokenUseCase.execute(token);
    }

    @Override
    public void logout(String token) {
        logOutUseCase.execute(token);
    }
}
