package practice.querydsl.productOrderSystem.domain.review.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import practice.querydsl.productOrderSystem.domain.review.persistence.entity.ReviewJpaEntity;

public interface ReviewJpaRepository extends CrudRepository<ReviewJpaEntity, Long> {
}
