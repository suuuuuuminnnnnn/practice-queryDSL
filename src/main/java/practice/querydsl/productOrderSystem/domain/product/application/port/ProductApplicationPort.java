package practice.querydsl.productOrderSystem.domain.product.application.port;

import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;

import java.util.List;

public interface ProductApplicationPort {
    void saveProduct(ProductCategory category, String name, String description, Long price, Business business);

    List<Product> findAllProducts();

    List<Product> searchProducts(SearchProductsRequest request);

    void updateProduct(Long id, ProductCategory category, String name, String description, Long price);

    void deleteProduct(Long id);
}
