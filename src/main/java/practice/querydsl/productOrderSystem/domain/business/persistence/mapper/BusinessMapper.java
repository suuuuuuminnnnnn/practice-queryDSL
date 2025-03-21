package practice.querydsl.productOrderSystem.domain.business.persistence.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.business.domain.Business;
import practice.querydsl.productOrderSystem.domain.business.persistence.entity.BusinessJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class BusinessMapper {

    private final UserMapper userMapper;

    public Business toDomain(BusinessJpaEntity businessJpaEntity) {
        return Business.builder()
                .id(businessJpaEntity.getId())
                .name(businessJpaEntity.getName())
                .description(businessJpaEntity.getDescription())
                .user(userMapper.toDomain(businessJpaEntity.getUser()))
                .build();
    }

    public BusinessJpaEntity toEntity(Business business) {
        return BusinessJpaEntity.builder()
                .id(business.getId())
                .name(business.getName())
                .description(business.getDescription())
                .user(userMapper.toEntity(business.getUser()))
                .build();
    }
}
