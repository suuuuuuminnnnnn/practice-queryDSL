package practice.querydsl.productOrderSystem.domain.product.persistence.port;

import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;

import java.util.List;

public interface ProductPersistencePort {
    Product findProductByProductId(Long productId);

    List<Product> findAllProducts();

    void saveProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> findProductsByConditions(SearchProductsRequest request);
}
