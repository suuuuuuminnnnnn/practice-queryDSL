package practice.querydsl.productOrderSystem.domain.order.application.useCase;

public interface CancelOrderUseCase {
    void execute(Long orderId);
}
