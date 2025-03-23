package practice.querydsl.productOrderSystem.domain.business.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

@Getter
@Builder
public class Business {
    private Long id;
    private String name;
    private String description;
    private User user;
}
