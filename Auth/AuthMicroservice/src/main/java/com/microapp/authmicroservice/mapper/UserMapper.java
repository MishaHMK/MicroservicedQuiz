package com.microapp.authmicroservice.mapper;

import com.microapp.authmicroservice.config.MapperConfig;
import com.microapp.authmicroservice.dto.UserRegisterRequestDto;
import com.microapp.authmicroservice.dto.UserRegisterResponseDto;
import com.microapp.authmicroservice.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toUser(UserRegisterRequestDto dto);

    UserRegisterResponseDto toResponse(User user);
}
