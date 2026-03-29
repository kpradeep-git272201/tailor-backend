package com.tailorapp.common.mapper;

import com.tailorapp.booking.dto.BookingDTO;
import com.tailorapp.booking.dto.BookingItemDTO;
import com.tailorapp.booking.entity.BookingEntity;
import com.tailorapp.booking.entity.BookingItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface BookingMapper {

    BookingDTO toDto(BookingEntity entity);

    List<BookingDTO> toDtoList(List<BookingEntity> entities);

    BookingItemDTO toItemDto(BookingItemEntity entity);

    List<BookingItemDTO> toItemDtoList(List<BookingItemEntity> entities);

    @Mapping(target = "bookingItemId", ignore = true)
    BookingItemEntity toItemEntity(BookingItemDTO dto);
}
