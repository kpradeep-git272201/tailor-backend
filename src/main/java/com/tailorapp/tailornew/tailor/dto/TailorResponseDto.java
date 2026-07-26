package com.tailorapp.tailornew.tailor.dto;

import com.tailorapp.tailornew.address.dto.TailorAddressResponseDto;
import com.tailorapp.tailornew.expertise.dto.TailorExpertiseResponseDto;
import com.tailorapp.tailornew.grade.Grade;
import com.tailorapp.tailornew.review.dto.TailorReviewResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TailorResponseDto {

    private Long tailorId;
    private String fullName;
    private String mobileNumber;
    private String email;
    private Integer experienceYears;
    private String profileImage;
    private Grade grade;
    private BigDecimal averageRating;
    private Integer reviewCount;
    private TailorAddressResponseDto address;
    private List<TailorExpertiseResponseDto> tailorExpertises = new ArrayList<>();
    private List<TailorReviewResponseDto> reviews = new ArrayList<>();
}
