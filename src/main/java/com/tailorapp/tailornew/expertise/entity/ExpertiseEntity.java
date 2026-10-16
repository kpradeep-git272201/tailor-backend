package com.tailorapp.tailornew.expertise.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import com.tailorapp.tailornew.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "expertise",
        schema = DatabaseConstants.TAILOR,
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_expertise_name", columnNames = "expertise_name")
        }
)

public class ExpertiseEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expertise_id")
    private Long expertiseId;

    @Column(name = "expertise_name", nullable = false, length = 100)
    private String expertiseName;

    @Column(name = "description", length = 500)
    private String description;

    @OneToMany(mappedBy = "expertise", fetch = FetchType.LAZY)
    private List<TailorExpertiseEntity> tailorExpertises = new ArrayList<>();

    public ExpertiseEntity() {
    }

    public Long getExpertiseId() {
        return expertiseId;
    }

    public void setExpertiseId(Long expertiseId) {
        this.expertiseId = expertiseId;
    }

    public String getExpertiseName() {
        return expertiseName;
    }

    public void setExpertiseName(String expertiseName) {
        this.expertiseName = expertiseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TailorExpertiseEntity> getTailorExpertises() {
        return tailorExpertises;
    }

    public void setTailorExpertises(List<TailorExpertiseEntity> tailorExpertises) {
        this.tailorExpertises = tailorExpertises;
    }
}
