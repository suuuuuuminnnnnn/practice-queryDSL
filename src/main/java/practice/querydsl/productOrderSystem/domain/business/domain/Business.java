package practice.querydsl.productOrderSystem.domain.business.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

@Getter
@Builder
public class Business {
    private final Long id;
    private final String name;
    private final String description;
    private final User user;
}
