package practice.querydsl.productOrderSystem.domain.product.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.FindProductsByConditionsUseCase;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindProductsByConditionsService implements FindProductsByConditionsUseCase {

    private final ProductPersistencePort productPersistencePort;

    @Override
    public List<Product> execute(SearchProductsRequest request) {
        return productPersistencePort.findProductsByConditions(request);
    }
}
