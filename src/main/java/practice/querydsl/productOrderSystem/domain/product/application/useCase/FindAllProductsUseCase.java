package practice.querydsl.productOrderSystem.domain.product.application.useCase;

import practice.querydsl.productOrderSystem.domain.product.domain.Product;

import java.util.List;

public interface FindAllProductsUseCase {
    List<Product> execute();
}
