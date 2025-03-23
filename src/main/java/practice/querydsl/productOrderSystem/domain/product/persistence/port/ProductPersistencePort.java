package practice.querydsl.productOrderSystem.domain.product.persistence.port;

import practice.querydsl.productOrderSystem.domain.product.domain.Product;

public interface ProductPersistencePort {
    Product findProductByProductId(Long productId);
}
