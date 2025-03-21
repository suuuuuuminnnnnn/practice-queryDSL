package practice.querydsl.productOrderSystem.domain.product.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.business.persistence.mapper.BusinessMapper;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final UserMapper userMapper;
    private final BusinessMapper businessMapper;

    public Product toDomain(ProductJpaEntity productJpaEntity) {
        return Product.builder()
                .id(productJpaEntity.getId())
                .name(productJpaEntity.getName())
                .description(productJpaEntity.getDescription())
                .price(productJpaEntity.getPrice())
                .category(productJpaEntity.getCategory())
                .business(businessMapper.toDomain(productJpaEntity.getBusiness()))
                .user(userMapper.toDomain(productJpaEntity.getUser()))
                .build();
    }

    public ProductJpaEntity toEntity(Product product) {
        return ProductJpaEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .business(businessMapper.toEntity(product.getBusiness()))
                .user(userMapper.toEntity(product.getUser()))
                .build();
    }
}
