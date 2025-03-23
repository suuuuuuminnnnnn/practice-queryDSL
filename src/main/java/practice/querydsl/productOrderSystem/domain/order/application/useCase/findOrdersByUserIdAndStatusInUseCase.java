package practice.querydsl.productOrderSystem.domain.order.application.useCase;

import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;

import java.util.List;

public interface findOrdersByUserIdAndStatusInUseCase {
    List<GetOrderResponse> execute();
}
