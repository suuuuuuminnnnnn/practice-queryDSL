package practice.querydsl.productOrderSystem.domain.product.application.adapter;

import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.application.port.ProductApplicationPort;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.*;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.service.FindProductsByConditionsService;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.List;

@Adapter(AdapterType.INBOUND)
@RequiredArgsConstructor
public class ProductApplicationAdapter implements ProductApplicationPort {

    private final DeleteProductUseCase deleteProductUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;
    private final FindProductsByConditionsUseCase productsByConditionsUseCase;
    private final SaveProductUseCase saveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final FindProductsByConditionsService findProductsByConditionsService;

    @Override
    public void saveProduct(ProductCategory category, String name, String description, Long price, Business business) {
        saveProductUseCase.execute(category, name, description, price, business);
    }

    @Override
    public List<Product> findAllProducts() {
        return findAllProductsUseCase.execute();
    }

    @Override
    public List<Product> searchProducts(SearchProductsRequest request) {
        return findProductsByConditionsService.execute(request);
    }

    @Override
    public void updateProduct(Long id, ProductCategory category, String name, String description, Long price) {
        updateProductUseCase.execute(id, category, name, description, price);
    }

    @Override
    public void deleteProduct(Long id) {
        deleteProductUseCase.execute(id);
    }
}
