package com.microapp.authmicroservice.security;

import com.microapp.authmicroservice.dto.UserLoginRequestDto;
import com.microapp.authmicroservice.dto.UserLoginResponseDto;
import com.microapp.authmicroservice.model.User;
import com.microapp.authmicroservice.repository.user.UserRepository;
import com.microapp.authmicroservice.security.jwt.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class    AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public UserLoginResponseDto login(UserLoginRequestDto requestDto) {
        User byEmail = userRepository.findByEmail(requestDto.email())
                .orElseThrow(
                        () -> new EntityNotFoundException("User with this email address does not exist")
                );

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password())
        );
        String token = jwtUtil.generateToken(authentication.getName(), byEmail.getId());
        return new UserLoginResponseDto(token);
    }
}
