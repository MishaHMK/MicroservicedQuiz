package com.microapp.authmicroservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRegisterResponseDto {
    private Long id;
    private String email;
    private String nickname;
}
