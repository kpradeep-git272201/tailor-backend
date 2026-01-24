package com.tailorapp.tailor.tailor.tailorDto;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Map;

public class TailorDTO {

    @NotBlank
    private String fullName;
    private String phone;
    private String email;
    private Integer categoryId;
    private String imagePath;

    // 🔥 Map for profileDetails (clean JSON)
    private Map<String, Object> profileDetails;

    private String isActive;
    private String isDeleted;
    private BigDecimal ratingAvg;

    // Getters & Setters
    public BigDecimal getRatingAvg() { return ratingAvg; }
    public void setRatingAvg(BigDecimal ratingAvg) { this.ratingAvg = ratingAvg; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public Map<String, Object> getProfileDetails() { return profileDetails; }
    public void setProfileDetails(Map<String, Object> profileDetails) { this.profileDetails = profileDetails; }

    public String getIsActive() { return isActive; }
    public void setIsActive(String isActive) { this.isActive = isActive; }

    public String getIsDeleted() { return isDeleted; }
    public void setIsDeleted(String isDeleted) { this.isDeleted = isDeleted; }
}
