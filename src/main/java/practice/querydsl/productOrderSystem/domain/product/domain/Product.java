package practice.querydsl.productOrderSystem.domain.product.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;

@Getter
@Builder
public class Product {
    private final Long id;
    private final ProductCategory category;
    private final String name;
    private final Long price;
    private final String description;
    private final Business business;
    private final User user;
}
