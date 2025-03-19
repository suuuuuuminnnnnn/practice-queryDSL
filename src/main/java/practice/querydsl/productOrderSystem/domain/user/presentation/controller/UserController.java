package practice.querydsl.productOrderSystem.domain.user.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.querydsl.productOrderSystem.domain.user.application.port.UserApplicationPort;
import practice.querydsl.productOrderSystem.domain.user.presentation.data.response.GetMoneyResponse;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationPort userApplicationPort;

    @GetMapping
    public ResponseEntity<GetMoneyResponse> getMoney() {
        return ResponseEntity.ok().body(userApplicationPort.findMoney());
    }

    @PostMapping("/{money}")
    public void addMoney(@PathVariable Long money) {
        userApplicationPort.addMoney(money);
    }
}
