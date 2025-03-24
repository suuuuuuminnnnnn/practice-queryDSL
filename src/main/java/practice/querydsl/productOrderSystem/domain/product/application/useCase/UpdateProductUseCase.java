package practice.querydsl.productOrderSystem.domain.product.application.useCase;

import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

public interface UpdateProductUseCase {
    void execute(Long id, ProductCategory category, String name, String description, Long price);
}
