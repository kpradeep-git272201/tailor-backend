package com.tailorapp.tailornew.review.entity;

import com.tailorapp.auth.entity.UserEntity;
import com.tailorapp.common.constants.DatabaseConstants;
import com.tailorapp.tailornew.BaseEntity;
import com.tailorapp.tailornew.tailor.entity.TailorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "tailor_review",
        schema = DatabaseConstants.TAILOR,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_tailor_review_user_tailor",
                        columnNames = {"tailor_id", "user_id"}
                )
        }
)
@Setter
@Getter
public class TailorReviewEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "tailor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tailor_review_tailor")
    )
    private TailorEntity tailor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tailor_review_user")
    )
    private UserEntity user;

    @Column(name = "rating", nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "review", length = 1000)
    private String review;

    protected TailorReviewEntity() {
    }
}
