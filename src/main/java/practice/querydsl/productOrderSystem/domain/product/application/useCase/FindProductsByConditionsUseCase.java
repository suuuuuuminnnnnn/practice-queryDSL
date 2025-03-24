package practice.querydsl.productOrderSystem.domain.product.application.useCase;

import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;

import java.util.List;

public interface FindProductsByConditionsUseCase {
    List<Product> execute(SearchProductsRequest request);
}
