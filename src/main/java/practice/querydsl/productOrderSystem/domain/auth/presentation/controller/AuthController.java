package practice.querydsl.productOrderSystem.domain.auth.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.querydsl.productOrderSystem.domain.auth.application.port.AuthApplicationPort;
import practice.querydsl.productOrderSystem.domain.auth.domain.RefreshToken;
import practice.querydsl.productOrderSystem.domain.auth.presentation.data.request.SignInRequest;
import practice.querydsl.productOrderSystem.domain.auth.presentation.data.request.SignUpRequest;
import practice.querydsl.productOrderSystem.domain.auth.presentation.data.response.SignInResponse;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthApplicationPort authApplicationPort;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signup(SignUpRequest request) {
        authApplicationPort.signup(request.email(), request.password(), request.role());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Void> signIn(SignInRequest request) {
        authApplicationPort.signin(request.email(), request.password());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reissue-token")
    public ResponseEntity<TokenDto> reissueToken(@RequestHeader("/Authorization") String token) {
        TokenDto tokenDto = authApplicationPort.refreshToken(token);
        return ResponseEntity.ok().body(tokenDto);
    }

}
