package practice.querydsl.productOrderSystem.domain.product.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import practice.querydsl.productOrderSystem.domain.product.persistence.entity.ProductJpaEntity;

public interface ProductJpaRepository extends CrudRepository<ProductJpaEntity, Long> {
}
