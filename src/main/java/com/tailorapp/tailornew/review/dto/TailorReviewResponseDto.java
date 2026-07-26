package com.tailorapp.tailornew.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TailorReviewResponseDto {
    private Long reviewId;
    private Long tailorId;
//    private Long userId;
    private String userName;
    private BigDecimal rating;
    private String review;
    private LocalDateTime createdAt;

}
