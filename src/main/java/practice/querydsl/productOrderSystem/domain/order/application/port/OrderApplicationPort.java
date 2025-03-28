package practice.querydsl.productOrderSystem.domain.order.application.port;

import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;

import java.util.List;

public interface OrderApplicationPort {
    void orderProduct(Long productId, Long quantity, OrderStatus status);

    List<GetOrderResponse> findOrdersByUserIdAndStatusIn();

    void cancelOrder(Long orderId);
}
