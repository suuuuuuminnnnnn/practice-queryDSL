package practice.querydsl.productOrderSystem.domain.user.application.useCase;

import practice.querydsl.productOrderSystem.domain.user.presentation.data.response.GetMoneyResponse;

public interface FindMoneyUseCase {
    GetMoneyResponse execute();
}
