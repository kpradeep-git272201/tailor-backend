package com.tailorapp.common.mapper;

import com.tailorapp.payment.dto.PaymentDTO;
import com.tailorapp.payment.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface PaymentMapper {

    PaymentDTO toDto(PaymentEntity entity);

    List<PaymentDTO> toDtoList(List<PaymentEntity> entities);
}
