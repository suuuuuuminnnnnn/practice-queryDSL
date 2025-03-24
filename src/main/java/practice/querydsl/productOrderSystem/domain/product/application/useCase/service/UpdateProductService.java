package practice.querydsl.productOrderSystem.domain.product.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.UpdateProductUseCase;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.persistence.repository.ProductJpaRepository;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {

    private final ProductPersistencePort productPersistencePort;
    private final ProductMapper productMapper;

    @Override
    public void execute(Long id, ProductCategory category, String name, String description, Long price) {
        Product product = productPersistencePort.findProductByProductId(id);

        ProductJpaEntity productJpaEntity = productMapper.toEntity(product);

        productJpaEntity.update(category, name, description, price);
    }
}
