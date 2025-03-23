package practice.querydsl.productOrderSystem.domain.order.persistence.adapter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.order.domain.Order;
import practice.querydsl.productOrderSystem.domain.order.domain.type.OrderStatus;
import practice.querydsl.productOrderSystem.domain.order.persistence.mapper.OrderMapper;
import practice.querydsl.productOrderSystem.domain.order.persistence.port.OrderPersistencePort;
import practice.querydsl.productOrderSystem.domain.order.persistence.repository.OrderJpaRepository;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.List;

import static practice.querydsl.productOrderSystem.domain.order.persistence.entity.QOrderJpaEntity.orderJpaEntity;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderMapper orderMapper;
    private final OrderJpaRepository orderJpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public void saveOrder(Order order) {
        orderJpaRepository.save(orderMapper.toEntity(order));
    }

    @Override
    public List<Order> findOrdersByUserIdAndStatusIn(UserJpaEntity user) {
        return queryFactory
                .selectFrom(orderJpaEntity)
                .where(orderJpaEntity.user.id.eq(user.getId())
                        .and(orderJpaEntity.status.in(OrderStatus.CANCELED, OrderStatus.DELIVERED)))
                .fetchAll()
                .stream()
                .map(orderMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteOrder(Order order) {
        orderJpaRepository.delete(orderMapper.toEntity(order));
    }
}
