package practice.querydsl.productOrderSystem.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;

import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final UserJpaEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getId().toString();
    }

    @Override
    public String getPassword() {
        return null;
    }
}
