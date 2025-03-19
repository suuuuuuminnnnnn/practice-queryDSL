package practice.querydsl.productOrderSystem.domain.business.domain;

import lombok.Builder;
import lombok.Getter;
import practice.querydsl.productOrderSystem.domain.user.domain.User;

@Getter
@Builder
public class Business {
    Long businessId;
    String businessName;
    String businessDescription;
    User user;
}
