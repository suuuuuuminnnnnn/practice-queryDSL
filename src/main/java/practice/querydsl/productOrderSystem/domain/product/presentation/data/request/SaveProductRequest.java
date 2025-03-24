package practice.querydsl.productOrderSystem.domain.product.presentation.data.request;

import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;

public record SaveProductRequest(
        ProductCategory category,
        String name,
        String description,
        Long price,
        Business business
) {
}
