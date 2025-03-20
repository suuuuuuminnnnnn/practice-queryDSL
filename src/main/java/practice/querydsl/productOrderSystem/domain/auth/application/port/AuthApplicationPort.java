package practice.querydsl.productOrderSystem.domain.auth.application.port;

import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

public interface AuthApplicationPort {
    void signup(String email, String password, UserRole role);

    TokenDto signin(String email, String password);

    TokenDto refreshToken(String token);

    void logout(String token);
}
