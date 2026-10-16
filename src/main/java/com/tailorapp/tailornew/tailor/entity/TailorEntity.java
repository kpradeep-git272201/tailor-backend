package com.tailorapp.tailornew.tailor.entity;

import com.tailorapp.common.constants.DatabaseConstants;

import com.tailorapp.tailornew.BaseEntity;
import com.tailorapp.tailornew.address.entity.TailorAddressEntity;
import com.tailorapp.tailornew.expertise.entity.TailorExpertiseEntity;
import com.tailorapp.tailornew.grade.Grade;
import com.tailorapp.tailornew.review.entity.TailorReviewEntity;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "tailor",
        schema = DatabaseConstants.TAILOR,
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_tailor_mobile_number", columnNames = "mobile_number"),
                @UniqueConstraint(name = "uk_tailor_email", columnNames = "email")
        }
)

public class TailorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tailor_id")
    private Long tailorId;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "mobile_number", nullable = false, length = 15)
    private String mobileNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "experience_years", nullable = false)
    private Integer experienceYears;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", nullable = false, length = 1)
    private Grade grade;

    @Column(name = "average_rating", precision = 3, scale = 2)
    private BigDecimal averageRating;

    @Column(name = "review_count")
    private Integer reviewCount = 0;

    @OneToOne(
            mappedBy = "tailor",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private TailorAddressEntity address;

    @OneToMany(
            mappedBy = "tailor",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<TailorExpertiseEntity> tailorExpertises = new ArrayList<>();

    @OneToMany(
            mappedBy = "tailor",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<TailorReviewEntity> reviews = new ArrayList<>();

    protected TailorEntity() {
    }

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

    public TailorAddressEntity getAddress() {
        return address;
    }

    public void setAddress(TailorAddressEntity address) {
        this.address = address;
    }

    public List<TailorExpertiseEntity> getTailorExpertises() {
        return tailorExpertises;
    }

    public void setTailorExpertises(List<TailorExpertiseEntity> tailorExpertises) {
        this.tailorExpertises = tailorExpertises;
    }

    public List<TailorReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<TailorReviewEntity> reviews) {
        this.reviews = reviews;
    }
}
