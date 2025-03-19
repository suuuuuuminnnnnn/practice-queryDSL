package practice.querydsl.productOrderSystem.domain.product.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;

@Getter
@Builder
public class Product {
    Long productId;
    ProductCategory productCategory;
    String productName;
    Long productPrice;
    String productDescription;
    Business business;
    User user;
}
