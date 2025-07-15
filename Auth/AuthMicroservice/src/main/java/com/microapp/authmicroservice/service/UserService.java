package com.microapp.authmicroservice.service;

import com.microapp.authmicroservice.dto.UserRegisterRequestDto;
import com.microapp.authmicroservice.dto.UserRegisterResponseDto;
import com.microapp.authmicroservice.exception.RegistrationException;

public interface UserService {
    UserRegisterResponseDto save(UserRegisterRequestDto userRegisterRequestDto)
            throws RegistrationException;
}
