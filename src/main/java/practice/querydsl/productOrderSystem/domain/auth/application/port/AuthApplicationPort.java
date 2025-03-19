package practice.querydsl.productOrderSystem.domain.auth.application.port;

import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

public interface AuthApplicationPort {
    void signup(String email, String password);

    TokenDto signin(String email, String password);

    TokenDto refreshToken(String token);

    void logout(String token);
}
