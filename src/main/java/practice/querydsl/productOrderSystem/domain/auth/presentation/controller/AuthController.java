package practice.querydsl.productOrderSystem.domain.auth.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.querydsl.productOrderSystem.domain.auth.application.port.AuthApplicationPort;
import practice.querydsl.productOrderSystem.domain.auth.presentation.data.request.SignInRequest;
import practice.querydsl.productOrderSystem.domain.auth.presentation.data.request.SignUpRequest;
import practice.querydsl.productOrderSystem.global.security.jwt.dto.TokenDto;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthApplicationPort authApplicationPort;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest request) {
        authApplicationPort.signUp(request.email(), request.password(), request.role());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInRequest request) {
        TokenDto tokenDto = authApplicationPort.signIn(request.email(), request.password());
        return ResponseEntity.ok().body(tokenDto);
    }

    @PostMapping("/reissue-token")
    public ResponseEntity<TokenDto> reissueToken(@RequestHeader("/Authorization") String token) {
        TokenDto tokenDto = authApplicationPort.refreshToken(token);
        return ResponseEntity.ok().body(tokenDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteToken(@RequestHeader("/Authorization") String token) {
        authApplicationPort.logout(token);
        return ResponseEntity.noContent().build();
    }

}
