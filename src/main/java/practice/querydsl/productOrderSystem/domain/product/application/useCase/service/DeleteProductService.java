package practice.querydsl.productOrderSystem.domain.product.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.product.application.useCase.DeleteProductUseCase;
import practice.querydsl.productOrderSystem.domain.product.domain.Product;
import practice.querydsl.productOrderSystem.domain.product.persistence.port.ProductPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;
import practice.querydsl.productOrderSystem.global.exception.CustomException;
import practice.querydsl.productOrderSystem.global.util.UserUtil;

@Service
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {

    private final UserUtil userUtil;
    private final ProductPersistencePort productPersistencePort;
    private final UserMapper userMapper;

    @Override
    public void execute(Long productId) {
        UserJpaEntity userJpaEntity = userUtil.getCurrentUser();

        Product product = productPersistencePort.findProductByProductId(productId);

        if (product.getUser().equals(userMapper.toDomain(userJpaEntity))) {
            throw new CustomException("잘못된 제품입니다.", HttpStatus.UNAUTHORIZED);
        }

        productPersistencePort.deleteProduct(productId);
    }
}
