package practice.querydsl.productOrderSystem.domain.user.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.user.application.useCase.FindMoneyUseCase;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.presentation.data.response.GetMoneyResponse;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class FindMoneyService implements FindMoneyUseCase {

    private final UserUtil userUtil;

    @Override
    public GetMoneyResponse execute() {
        UserJpaEntity user = userUtil.getCurrentUser();

    }
}
