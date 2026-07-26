package com.tailorapp.tailornew.expertise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TailorExpertiseResponseDto {
    private Long id;
    private Long tailorId;
    private ExpertiseResponseDto expertise;
}
