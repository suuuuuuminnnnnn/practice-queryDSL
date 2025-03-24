package practice.querydsl.productOrderSystem.domain.product.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.SaveProductUseCase;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {

    private final ProductPersistencePort productPersistencePort;

    @Override
    public void execute(ProductCategory category, String name, String description, Long price, Business business) {
        Product product = Product.builder()
                .category(category)
                .name(name)
                .description(description)
                .price(price)
                .business(business)
                .user(business.getUser())
                .build();

        productPersistencePort.saveProduct(product);
    }

}
