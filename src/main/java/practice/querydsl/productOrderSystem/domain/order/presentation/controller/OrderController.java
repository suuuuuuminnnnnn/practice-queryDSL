package practice.querydsl.productOrderSystem.domain.order.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.querydsl.productOrderSystem.domain.order.application.port.OrderApplicationPort;

@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationPort orderApplicationPort;

    @PostMapping
    public void orderProduct(@RequestBody ) {
        orderApplicationPort.orderProduct();
    }


}
