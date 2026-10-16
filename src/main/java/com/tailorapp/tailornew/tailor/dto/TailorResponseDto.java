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

    private List<String> expertiseList= new ArrayList<>();

    public Long getTailorId() {
        return tailorId;
    }

    public void setTailorId(Long tailorId) {
        this.tailorId = tailorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public TailorAddressResponseDto getAddress() {
        return address;
    }

    public void setAddress(TailorAddressResponseDto address) {
        this.address = address;
    }

    public List<TailorExpertiseResponseDto> getTailorExpertises() {
        return tailorExpertises;
    }

    public void setTailorExpertises(List<TailorExpertiseResponseDto> tailorExpertises) {
        this.tailorExpertises = tailorExpertises;
    }

    public List<TailorReviewResponseDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<TailorReviewResponseDto> reviews) {
        this.reviews = reviews;
    }

    public List<String> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<String> expertiseList) {
        this.expertiseList = expertiseList;
    }
}
