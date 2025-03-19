package practice.querydsl.productOrderSystem.domain.user.persistence.adapter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;
import practice.querydsl.productOrderSystem.global.annotation.adapter.Adapter;
import practice.querydsl.productOrderSystem.global.annotation.adapter.constant.AdapterType;

@Adapter(AdapterType.OUTBOUND)
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final JPAQueryFactory queryFactory;

    @Override
    public Long findMoney(Long userId) {

    }
}
