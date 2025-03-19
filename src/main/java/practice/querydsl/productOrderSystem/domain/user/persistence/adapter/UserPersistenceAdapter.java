package practice.querydsl.productOrderSystem.domain.user.persistence.adapter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.domain.user.persistence.repository.UserJpaRepository;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

import static practice.querydsl.productOrderSystem.domain.user.persistence.entity.QUserJpaEntity.userJpaEntity;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final JPAQueryFactory queryFactory;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Long findMoneyByUserId(Long userId) {
        return queryFactory
                .select(userJpaEntity.money)
                .from(userJpaEntity)
                .where(userJpaEntity.id.eq(userId))
                .fetchOne();
    }

    @Override
    public UserJpaEntity findUserByEmail(String email) {
        return queryFactory
                .selectFrom(userJpaEntity)
                .where(userJpaEntity.email.eq(email))
                .fetchOne();
    }

    @Override
    public void saveUser(UserJpaEntity user) {
        userJpaRepository.save(user);
    }
}
