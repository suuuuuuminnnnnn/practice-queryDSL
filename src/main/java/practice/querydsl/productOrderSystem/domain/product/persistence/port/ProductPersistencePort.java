package practice.querydsl.productOrderSystem.domain.product.persistence.port;

import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

import java.util.List;

public interface ProductPersistencePort {
    Product findProductByProductId(Long productId);

    List<Product> findAllProducts();

    void saveProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> findProductsByCategoryAndNameAndPriceRangeAndBusiness(ProductCategory category, String name, Long minPrice, Long maxPrice, Business business);
}
