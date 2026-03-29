package com.tailorapp.common.mapper;

import com.tailorapp.order.dto.OrderDTO;
import com.tailorapp.order.dto.OrderItemDTO;
import com.tailorapp.order.entity.OrderEntity;
import com.tailorapp.order.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface OrderMapper {

    OrderDTO toDto(OrderEntity entity);

    List<OrderDTO> toDtoList(List<OrderEntity> entities);

    OrderItemDTO toItemDto(OrderItemEntity entity);

    List<OrderItemDTO> toItemDtoList(List<OrderItemEntity> entities);
}
