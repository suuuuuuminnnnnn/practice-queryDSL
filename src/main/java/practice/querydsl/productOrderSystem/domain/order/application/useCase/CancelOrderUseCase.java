package practice.querydsl.productOrderSystem.domain.order.application.useCase;

public interface CancelOrder {
    void execute(Long orderId);
}
