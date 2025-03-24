package practice.querydsl.productOrderSystem.domain.product.application.useCase;

import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

public interface SaveProductUseCase {
    void execute(ProductCategory category, String name, String description, Long price, Business business);
}
