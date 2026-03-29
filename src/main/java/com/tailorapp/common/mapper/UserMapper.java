package com.tailorapp.common.mapper;

import com.tailorapp.auth.dto.RegisterRequest;
import com.tailorapp.auth.dto.UserDTO;
import com.tailorapp.auth.entity.UserEntity;
import org.mapstruct.*;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring")
@Primary
public interface UserMapper {

    UserDTO toDto(UserEntity entity);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", constant = "CUSTOMER")
    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "emailVerified", constant = "false")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    UserEntity toEntity(RegisterRequest request);
}
