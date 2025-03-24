package practice.querydsl.productOrderSystem.domain.product.presentation.data.request;

import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

public record UpdateProductRequest(
        Long id,
        ProductCategory category,
        String name,
        String description,
        Long price
) {
}
