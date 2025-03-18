package practice.querydsl.productOrderSystem.global.security.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.querydsl.productOrderSystem.domain.user.persistence.repository.UserJpaRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        return new CustomUserDetails(userJpaRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다.")));
    }
}
