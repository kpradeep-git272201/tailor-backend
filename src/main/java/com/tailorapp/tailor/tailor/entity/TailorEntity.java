package com.tailorapp.tailor.tailor.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import com.tailorapp.tailor.tailorCatagory.TailorCatEntity;
import jakarta.persistence.*;
import tools.jackson.databind.JsonNode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tailors", schema = DatabaseConstants.TAILOR)
public class TailorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tailorId;
    @Column(nullable = false, length = 100)
    private String fullName;
    private String phone;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private TailorCatEntity category;
    private BigDecimal ratingAvg;
    private String imagePath;
    @Column(columnDefinition = "jsonb")
    private String profileDetails;
    private Boolean activeFlag;
    private LocalDateTime createdAt;
    private String isActive;

    private String isDeleted;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TailorCatEntity getCategory() {
        return category;
    }

    public void setCategory(TailorCatEntity category) {
        this.category = category;
    }

    public BigDecimal getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(BigDecimal ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public String getProfileDetails() {
        return profileDetails;
    }

    public void setProfileDetails(String profileDetails) {
        this.profileDetails = profileDetails;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
