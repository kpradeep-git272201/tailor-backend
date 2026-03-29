package com.tailorapp.common.mapper;

import com.tailorapp.measurement.dto.AddMeasurementRequest;
import com.tailorapp.measurement.dto.MeasurementDTO;
import com.tailorapp.measurement.entity.MeasurementEntity;
import org.mapstruct.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface MeasurementMapper {

    MeasurementDTO toDto(MeasurementEntity entity);

    List<MeasurementDTO> toDtoList(List<MeasurementEntity> entities);

    @Mapping(target = "measurementId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    MeasurementEntity toEntity(AddMeasurementRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "measurementId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(AddMeasurementRequest request, @MappingTarget MeasurementEntity entity);
}
