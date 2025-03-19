package practice.querydsl.productOrderSystem.domain.user.persistence.mapper;

import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.user.domain.User;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

@Component
public class UserMapper {

    public User toDomain(UserJpaEntity userJpaEntity) {
        return User.builder()
                .id(userJpaEntity.getId())
                .email(userJpaEntity.getEmail())
                .password(userJpaEntity.getPassword())
                .money(userJpaEntity.getMoney())
                .role(userJpaEntity.getRole())
                .build();
    }

    public UserJpaEntity toEntity(User user) {
        return UserJpaEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .money(user.getMoney())
                .role(user.getRole())
                .build();
    }
}
