package com.tailorapp.common.mapper;

import com.tailorapp.catalog.address.dto.AddAddressRequest;
import com.tailorapp.catalog.address.dto.AddressDTO;
import com.tailorapp.catalog.address.entity.AddressEntity;
import org.mapstruct.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface AddressMapper {

    AddressDTO toDto(AddressEntity entity);

    List<AddressDTO> toDtoList(List<AddressEntity> entities);

    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AddressEntity toEntity(AddAddressRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(AddAddressRequest request, @MappingTarget AddressEntity entity);
}
