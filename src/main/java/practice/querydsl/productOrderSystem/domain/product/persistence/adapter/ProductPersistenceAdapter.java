package practice.querydsl.productOrderSystem.domain.product.persistence.adapter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.persistence.repository.ProductJpaRepository;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import static practice.querydsl.productOrderSystem.domain.product.persistence.entity.QProductJpaEntity.productJpaEntity;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;
    private final JPAQueryFactory queryFactory;

    @Override
    public Product findProductByProductId(Long productId) {
        ProductJpaEntity entity = queryFactory
                .selectFrom(productJpaEntity)
                .where(productJpaEntity.id.eq(productId))
                .fetchOne();

        return productMapper.toDomain(entity);
    }
}
