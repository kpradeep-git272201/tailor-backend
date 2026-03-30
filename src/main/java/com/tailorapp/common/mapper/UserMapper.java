package com.tailorapp.common.mapper;

import com.tailorapp.auth.dto.RegisterRequest;
import com.tailorapp.auth.dto.UserDTO;
import com.tailorapp.auth.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring")
@Primary
public interface UserMapper {

    // ENTITY → DTO
    UserDTO toDto(UserEntity entity);

    //DTO → ENTITY
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "phoneNumber", source = "phoneNumber") // या request.mobile अगर वो है
    @Mapping(target = "role", constant = "CUSTOMER")
    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "isDeleted", constant = "false")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    UserEntity toEntity(RegisterRequest request);
}