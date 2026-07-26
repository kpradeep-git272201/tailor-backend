package com.tailorapp.tailornew.expertise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExpertiseResponseDto {
    private Long expertiseId;
    private String expertiseName;
    private String description;
}
