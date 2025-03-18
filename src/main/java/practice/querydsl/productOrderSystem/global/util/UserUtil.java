package practice.querydsl.productOrderSystem.global.util;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.repository.UserJpaRepository;
import practice.querydsl.productOrderSystem.global.exception.CustomException;
import practice.querydsl.productOrderSystem.global.security.auth.CustomUserDetails;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserJpaRepository userJpaRepository;

    public UserJpaEntity getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUserDetails) {
            String userId = ((CustomUserDetails) principal).getUsername();
            return userJpaRepository.findById(Long.valueOf(userId))
                    .orElseThrow(() -> new CustomException("유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        } else {
            throw new CustomException("현재 인증되어 있는 유저의 principal이 유효하지 않습니다.", HttpStatus.UNAUTHORIZED);
        }
    }
}
