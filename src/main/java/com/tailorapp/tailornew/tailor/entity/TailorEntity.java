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
@Setter
@Getter
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
}
