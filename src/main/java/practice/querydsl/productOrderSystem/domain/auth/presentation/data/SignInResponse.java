package practice.querydsl.productOrderSystem.domain.auth.presentation.data;

import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

public record SignInResponse(
        TokenDto tokenDto
) {
}
