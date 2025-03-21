package practice.querydsl.productOrderSystem.domain.auth.application.useCase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.querydsl.productOrderSystem.domain.auth.application.useCase.SignUpUseCase;
import practice.querydsl.productOrderSystem.domain.user.domain.type.UserRole;
import practice.querydsl.productOrderSystem.domain.user.persistence.entity.UserJpaEntity;
import practice.querydsl.productOrderSystem.domain.user.persistence.port.UserPersistencePort;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUseCase {

    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void execute(String email, String password, UserRole role) {
        UserJpaEntity userJpaEntity = UserJpaEntity.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .money(10000L)
                .role(role)
                .build();

        userPersistencePort.saveUser(userJpaEntity);
    }
}
