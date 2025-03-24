package practice.querydsl.productOrderSystem.domain.product.persistence.adapter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;
import practice.querydsl.productOrderSystem.domain.product.persistence.mapper.ProductMapper;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.product.persistence.repository.ProductJpaRepository;
import practice.querydsl.productOrderSystem.domain.product.presentation.data.request.SearchProductsRequest;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.ArrayList;
import java.util.List;

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
                .leftJoin(productJpaEntity.business).fetchJoin()
                .where(productJpaEntity.id.eq(productId))
                .fetchOne();

        return productMapper.toDomain(entity);
    }

    @Override
    public List<Product> findAllProducts() {
        return queryFactory
                .selectFrom(productJpaEntity)
                .leftJoin(productJpaEntity.business).fetchJoin()
                .fetchAll()
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public void saveProduct(Product product) {
        productJpaRepository.save(productMapper.toEntity(product));
    }

    @Override
    public void deleteProduct(Long productId) {
        productJpaRepository.deleteById(productId);
    }

    @Override
    public List<Product> findProductsByConditions(SearchProductsRequest request) {
        return queryFactory
                .selectFrom(productJpaEntity)
                .leftJoin(productJpaEntity.business).fetchJoin()
                .where(buildConditions(request))
                .fetch()
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

    private BooleanExpression[] buildConditions(SearchProductsRequest request) {
        if (request == null) return new BooleanExpression[0];

        List<BooleanExpression> conditions = new ArrayList<>();
        if (request.category() != null) {
            conditions.add(productJpaEntity.category.eq(request.category()));
        }
        if (request.name() != null) {
            conditions.add(productJpaEntity.name.eq(request.name()));
        }
        if (request.minPrice() != null) {
            conditions.add(productJpaEntity.price.goe(request.minPrice()));
        }
        if (request.maxPrice() != null) {
            conditions.add(productJpaEntity.price.loe(request.maxPrice()));
        }
        if (request.businessId() != null) {
            conditions.add(productJpaEntity.business.id.eq(request.businessId()));
        }
        return conditions.toArray(new BooleanExpression[0]);
    }
}
