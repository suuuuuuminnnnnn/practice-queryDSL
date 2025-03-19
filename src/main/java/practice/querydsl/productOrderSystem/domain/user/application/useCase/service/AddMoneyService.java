package practice.querydsl.productOrderSystem.domain.user.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.querydsl.productOrderSystem.domain.user.application.useCase.AddMoneyUseCase;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class AddMoneyService implements AddMoneyUseCase {

    private final UserUtil userUtil;

    @Override
    @Transactional
    public void execute(Long money) {
        UserJpaEntity user = userUtil.getCurrentUser();
        user.addMoney(money);
    }
}
