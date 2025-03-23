package practice.querydsl.productOrderSystem.domain.order.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.querydsl.productOrderSystem.domain.order.application.port.OrderApplicationPort;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.request.OrderProductRequest;
import practice.querydsl.productOrderSystem.domain.order.presentation.data.response.GetOrderResponse;

import java.util.List;

@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationPort orderApplicationPort;

    @PostMapping
    public void orderProduct(@RequestBody OrderProductRequest request) {
        orderApplicationPort.orderProduct(request.productId(), request.quantity(), request.status());
    }

    @GetMapping
    public List<GetOrderResponse> getOrders() {
        return orderApplicationPort.findOrdersByUserIdAndStatusIn();
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderApplicationPort.cancelOrder(orderId);
    }
}
