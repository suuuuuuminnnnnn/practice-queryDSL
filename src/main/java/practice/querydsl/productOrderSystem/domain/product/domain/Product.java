package practice.querydsl.productOrderSystem.domain.product.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;

@Getter
@Builder
public class Product {
    private final Long productId;
    private final ProductCategory productCategory;
    private final String productName;
    private final Long productPrice;
    private final String productDescription;
    private final Business business;
    private final User user;
}
