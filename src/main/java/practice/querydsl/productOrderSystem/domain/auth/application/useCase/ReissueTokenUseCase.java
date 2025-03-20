package practice.querydsl.productOrderSystem.domain.auth.application.useCase;

import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

public interface ReissueTokenUseCase {
    TokenDto execute(String token);
}
