package practice.querydsl.productOrderSystem.domain.user.persistence.adapter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import java.util.Optional;

import static practice.querydsl.productOrderSystem.domain.user.persistence.entity.QUserJpaEntity.userJpaEntity;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final JPAQueryFactory queryFactory;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findUserByUserId(Long userId) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(userJpaEntity)
                        .where(userJpaEntity.id.eq(userId))
                        .fetchOne())
                .map(userMapper::toDomain);
    }
}
