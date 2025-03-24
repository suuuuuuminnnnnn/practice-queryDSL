package practice.querydsl.productOrderSystem.domain.product.presentation.data.request;

import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

public record SearchProductsRequest(
        ProductCategory category,
        String name,
        Long minPrice,
        Long maxPrice,
        Long businessId
) {
}
