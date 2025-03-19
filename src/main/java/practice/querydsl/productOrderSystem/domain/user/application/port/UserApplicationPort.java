package practice.querydsl.productOrderSystem.domain.user.application.port;

public interface UserApplicationPort {
    void addMoney(Long money);

    GetMoneyResponse findMoney();
}
