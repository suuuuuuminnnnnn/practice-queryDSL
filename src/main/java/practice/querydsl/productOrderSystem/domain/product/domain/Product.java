package practice.querydsl.productOrderSystem.domain.product.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.product.domain.type.ProductCategory;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;

@Getter
@Builder
public class Product {
    private Long id;
    private ProductCategory category;
    private String name;
    private Long price;
    private String description;
    private Business business;
    private User user;
}
