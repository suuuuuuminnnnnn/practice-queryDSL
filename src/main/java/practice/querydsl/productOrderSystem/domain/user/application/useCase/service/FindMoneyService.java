package practice.querydsl.productOrderSystem.domain.user.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.user.application.useCase.FindMoneyUseCase;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.presentation.data.response.GetMoneyResponse;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class FindMoneyService implements FindMoneyUseCase {

    private final UserUtil userUtil;
    private final UserPersistencePort userPersistencePort;

    @Override
    public GetMoneyResponse execute() {
        UserJpaEntity user = userUtil.getCurrentUser();
        User user1 = userPersistencePort.findUserByUserId(user.getId())
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return new GetMoneyResponse(user1.getMoney());
    }
}
