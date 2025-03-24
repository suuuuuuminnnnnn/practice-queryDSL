package practice.querydsl.productOrderSystem.domain.product.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.querydsl.productOrderSystem.domain.product.application.port.ProductApplicationPort;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SaveProductRequest;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.UpdateProductRequest;

import java.util.List;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductApplicationPort productApplicationPort;

    @PostMapping("/save")
    public void save(@RequestBody SaveProductRequest request) {
        productApplicationPort.saveProduct(request.category(), request.name(), request.description(), request.price(), request.business());
    }

    @PatchMapping
    public void update(@RequestBody UpdateProductRequest request) {
        productApplicationPort.updateProduct(request.id(), request.category(), request.name(), request.description(), request.price());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productApplicationPort.deleteProduct(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return productApplicationPort.findAllProducts();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestBody SearchProductsRequest request) {
        return productApplicationPort.searchProducts(request);
    }
}
