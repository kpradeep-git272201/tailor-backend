package com.tailorapp.common.mapper;

import com.tailorapp.catalog.cart.dto.AddToCartRequest;
import com.tailorapp.catalog.cart.dto.CartDTO;
import com.tailorapp.catalog.cart.entity.CartEntity;
import org.mapstruct.*;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface CartMapper {

    CartDTO toDto(CartEntity entity);

    List<CartDTO> toDtoList(List<CartEntity> entities);

    CartEntity toEntity(CartDTO dto);

    @Mapping(target = "cartId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CartEntity toEntity(AddToCartRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cartId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(AddToCartRequest request, @MappingTarget CartEntity entity);
}
