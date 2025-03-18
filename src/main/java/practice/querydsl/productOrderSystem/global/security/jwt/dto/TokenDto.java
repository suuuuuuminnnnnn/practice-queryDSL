package practice.querydsl.productOrderSystem.global.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class TokenDto {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime accessTokenExpAt;
    private LocalDateTime refreshTokenExpAt;
}
