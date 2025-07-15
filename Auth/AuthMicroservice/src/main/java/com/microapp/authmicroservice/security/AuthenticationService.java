package com.microapp.authmicroservice.security;

import com.microapp.authmicroservice.dto.UserLoginRequestDto;
import com.microapp.authmicroservice.dto.UserLoginResponseDto;
import com.microapp.authmicroservice.model.User;
import com.microapp.authmicroservice.repository.user.UserRepository;
import com.microapp.authmicroservice.security.jwt.JwtUtil;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public UserLoginResponseDto login(UserLoginRequestDto requestDto) {
        Optional<User> byEmail = userRepository.findByEmail(requestDto.email());
        if (byEmail.isPresent() && byEmail.get().getPassword().isEmpty()) {
            throw new BadCredentialsException("You have to register at first");
        }
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token);
    }
}
