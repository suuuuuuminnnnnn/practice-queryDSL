package practice.querydsl.productOrderSystem.domain.user.application;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.application.port.UserApplicationPort;
import practice.querydsl.productOrderSystem.domain.user.application.useCase.AddMoneyUseCase;
import practice.querydsl.productOrderSystem.domain.user.application.useCase.FindMoneyUseCase;
import practice.querydsl.productOrderSystem.domain.user.presentation.data.response.GetMoneyResponse;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

@Adapter(AdapterType.INBOUND)
@RequiredArgsConstructor
public class UserApplicationAdapter implements UserApplicationPort {

    private final AddMoneyUseCase addMoneyUseCase;
    private final FindMoneyUseCase findMoneyUseCase;

    @Override
    public void addMoney(Long money) {
        addMoneyUseCase.execute(money);
    }

    @Override
    public GetMoneyResponse findMoney() {
        return findMoneyUseCase.execute();
    }


}
