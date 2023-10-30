package com.praktika.farmakon.mapper;


import com.praktika.farmakon.dto.request.auth.LoginRequest;
import com.praktika.farmakon.dto.request.auth.RegisterRequest;
import com.praktika.farmakon.dto.response.user.UserResponse;
import com.praktika.farmakon.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserResponse toDto(User entity);
    User fromDto(LoginRequest dto);
    User fromDto(RegisterRequest dto);
}
