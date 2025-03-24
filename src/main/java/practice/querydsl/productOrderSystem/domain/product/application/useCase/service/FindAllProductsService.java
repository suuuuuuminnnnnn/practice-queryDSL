package practice.querydsl.productOrderSystem.domain.product.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.FindAllProductsUseCase;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProductsService implements FindAllProductsUseCase {

    private final ProductPersistencePort productPersistencePort;

    @Override
    public List<Product> execute() {
        return productPersistencePort.findAllProducts();
    }
}
