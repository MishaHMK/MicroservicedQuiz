package com.microapp.authmicroservice.service;

import com.microapp.authmicroservice.dto.UserRegisterRequestDto;
import com.microapp.authmicroservice.dto.UserRegisterResponseDto;
import com.microapp.authmicroservice.exception.RegistrationException;
import com.microapp.authmicroservice.mapper.UserMapper;
import com.microapp.authmicroservice.model.User;
import com.microapp.authmicroservice.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserRegisterResponseDto save(UserRegisterRequestDto requestDto) {
        String email = requestDto.getEmail();
        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            checkUserRegistered(byEmail.get());
        }
        User user = userMapper.toUser(requestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (byEmail.isPresent() && byEmail.get().getPassword() == null) {
            userRepository.save(user.setId(byEmail.get().getId()));
        } else {
            userRepository.save(user);
        }
        UserRegisterResponseDto response = userMapper.toResponse(user);
        return response;
    }

    private void checkUserRegistered(User user) {
        if (user.getPassword() != null) {
            throw new RegistrationException("User with email "
                    + user.getEmail() + " is already registered");
        }
    }
}
