package practice.querydsl.productOrderSystem.domain.business.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

@Getter
@Builder
public class Business {
    private final Long businessId;
    private final String businessName;
    private final String businessDescription;
    private final User user;
}
