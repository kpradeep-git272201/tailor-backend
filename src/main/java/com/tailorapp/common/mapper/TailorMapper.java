package com.tailorapp.common.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tailorapp.tailor.tailor.entity.TailorEntity;
import com.tailorapp.tailor.tailor.tailorDto.TailorDTO;
import com.tailorapp.tailor.tailor.tailorDto.UpdatedTailorDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
@Primary
public interface TailorMapper {

    ObjectMapper objectMapper = new ObjectMapper();

    TailorDTO toDto(TailorEntity entity);

    List<TailorDTO> toDtoList(List<TailorEntity> entities);

    TailorEntity toEntity(TailorDTO dto);

    List<TailorEntity> toEntityList(List<TailorDTO> dtoList);

    /* ================= UPDATE (PATCH) ================= */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(
            UpdatedTailorDTO dto,
            @MappingTarget TailorEntity entity
    );

    /* ========= CUSTOM JSON MAPPING ========= */
    default Map<String, Object> map(String profileDetails) {
        if (profileDetails == null || profileDetails.isBlank()) return null;
        try {
            // String JSON → Map<String,Object>
            return objectMapper.readValue(profileDetails, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Invalid profileDetails JSON", e);
        }
    }

    default String map(Map<String, Object> profileDetails) {
        if (profileDetails == null) return null;
        try {
            // Map → String JSON (for saving to DB)
            return objectMapper.writeValueAsString(profileDetails);
        } catch (Exception e) {
            throw new RuntimeException("Error converting profileDetails Map to String", e);
        }
    }
}
