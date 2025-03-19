package practice.querydsl.productOrderSystem.domain.user.application;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.application.port.UserApplicationPort;
import practice.querydsl.productOrderSystem.domain.user.application.useCase.AddMoneyUseCase;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

@Adapter(AdapterType.INBOUND)
@RequiredArgsConstructor
public class UserApplicationAdapter implements UserApplicationPort {

    private final AddMoneyUseCase addMoneyUseCase;

    @Override
    public void addMoney(Long money) {
        addMoneyUseCase.execute(money);
    }


}
