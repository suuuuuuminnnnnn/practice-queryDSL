package practice.querydsl.productOrderSystem.domain.user.application.port;

import practice.querydsl.productOrderSystem.domain.user.presentation.data.response.GetMoneyResponse;

public interface UserApplicationPort {

    void addMoney(Long money);

    GetMoneyResponse findMoney();
}
