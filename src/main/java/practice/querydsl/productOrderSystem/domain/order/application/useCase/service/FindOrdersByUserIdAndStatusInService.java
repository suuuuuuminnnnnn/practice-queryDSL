package practice.querydsl.productOrderSystem.domain.order.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.order.application.useCase.FindOrdersByUserIdAndStatusInUseCase;
import practice.querydsl.productOrderSystem.domain.order.persistence.mapper.OrderMapper;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindOrdersByUserIdAndStatusInService implements FindOrdersByUserIdAndStatusInUseCase {

    private final UserUtil userUtil;
    private final OrderPersistencePort orderPersistencePort;
    private final OrderMapper orderMapper;

    @Override
    public List<GetOrderResponse> execute() {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();

        return orderPersistencePort.findOrdersByUserIdAndStatusIn(userJpaEntity)
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }

}
