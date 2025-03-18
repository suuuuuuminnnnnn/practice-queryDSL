package practice.querydsl.productOrderSystem.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import practice.querydsl.productOrderSystem.domain.user.persistence.repository.UserJpaRepository;
import practice.querydsl.productOrderSystem.global.security.auth.CustomUserDetailsService;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final Long ACCESS_TOKEN_TIME = 60L * 30 * 4;
    private static final Long REFRESH_TOKEN_TIME = 60L * 60 * 24 * 7;

    @Value("${jwt.secret}")
    private String secretKey;
    private static Key key;
    private final CustomUserDetailsService customUserDetailsService;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenDto generateToken(Long userId) {
        return TokenDto.builder()
                .accessToken(generateAccessToken(userId))
                .refreshToken(generateRefreshToken(userId))
                .accessTokenExpAt(LocalDateTime.now().plusSeconds(ACCESS_TOKEN_TIME))
                .refreshTokenExpAt(LocalDateTime.now().plusSeconds(REFRESH_TOKEN_TIME))
                .build();
    }

    public String getUserIdFromRefreshToken(String token) {
        return getRefreshTokenSubject(token);
    }

    public String getUserIdFromAccessToken(String token) {
        return getAccessTokenSubject(token);
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String accessToken) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(getAccessTokenSubject(accessToken));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getAccessTokenSubject(String accessToken) {
        return getTokenBody(removePrefix(accessToken), key).getSubject();
    }

    private String getRefreshTokenSubject(String refreshToken) {
        return getTokenBody(removePrefix(refreshToken), key).getSubject();
    }

    public static Claims getTokenBody(String token, Key secret) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String generateAccessToken(Long userId) {
        Date accessTokenExpTime = new Date(System.currentTimeMillis() + ACCESS_TOKEN_TIME * 1000);

        return Jwts.builder()
                .setSubject(userId.toString())
                .claim(AUTHORITIES_KEY, "jwt")
                .setIssuedAt(new Date())
                .setExpiration(accessTokenExpTime)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(Long userId) {
        Date refreshTokenExpTime = new Date(System.currentTimeMillis() + REFRESH_TOKEN_TIME * 1000);

        return Jwts.builder()
                .setSubject(userId.toString())
                .setExpiration(refreshTokenExpTime)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Long getExpiration(String accessToken) {
        Claims claims = getTokenBody(accessToken, key);
        return claims.getExpiration().getTime();
    }

    private String removePrefix(String token) {
        return token.replace(BEARER_PREFIX, "");
    }
}
