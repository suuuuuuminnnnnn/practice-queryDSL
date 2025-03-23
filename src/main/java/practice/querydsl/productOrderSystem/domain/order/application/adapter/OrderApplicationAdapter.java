package practice.querydsl.productOrderSystem.domain.order.application.adapter;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.application.port.OrderApplicationPort;
import practice.querydsl.productOrderSystem.domain.order.application.useCase.CancelOrderUseCase;
import practice.querydsl.productOrderSystem.domain.order.application.useCase.FindOrdersByUserIdAndStatusInUseCase;
import practice.querydsl.productOrderSystem.domain.order.application.useCase.OrderProductUseCase;
import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.List;

@Adapter(AdapterType.INBOUND)
@RequiredArgsConstructor
public class OrderApplicationAdapter implements OrderApplicationPort {

    private final CancelOrderUseCase cancelOrderUseCase;
    private final FindOrdersByUserIdAndStatusInUseCase findOrdersByUserIdAndStatusInUseCase;
    private final OrderProductUseCase orderProductUseCase;

    @Override
    public void orderProduct(Long productId, Long quantity, OrderStatus status) {
        orderProductUseCase.execute(productId, quantity, status);
    }

    @Override
    public List<GetOrderResponse> findOrdersByUserIdAndStatusIn() {
        return findOrdersByUserIdAndStatusInUseCase.execute();
    }

    @Override
    public void cancelOrder(Long orderId) {
        cancelOrderUseCase.execute(orderId);
    }
}
