package practice.querydsl.productOrderSystem.domain.order.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.querydsl.productOrderSystem.domain.order.application.useCase.OrderProductUseCase;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class OrderProductService implements OrderProductUseCase {

    private final OrderPersistencePort orderPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final UserMapper userMapper;
    private final UserUtil userUtil;

    @Override
    @Transactional
    public void execute(Long productId, Long quantity, OrderStatus status) {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();

        Product product = productPersistencePort.findProductByProductId(productId);
        Order order = Order.builder()
                .product(product)
                .quantity(quantity)
                .status(status)
                .user(userMapper.toDomain(userJpaEntity))
                .build();

        userJpaEntity.removeMoney(product.getPrice());

        orderPersistencePort.saveOrder(order);
    }
}
