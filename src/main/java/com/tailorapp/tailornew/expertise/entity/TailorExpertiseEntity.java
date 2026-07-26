package com.tailorapp.tailornew.expertise.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import com.tailorapp.tailornew.BaseEntity;
import com.tailorapp.tailornew.tailor.entity.TailorEntity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "tailor_expertise",
        schema = DatabaseConstants.TAILOR,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_tailor_expertise_tailor_expertise",
                        columnNames = {"tailor_id", "expertise_id"}
                )
        }
)
@Setter
@Getter
public class TailorExpertiseEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "tailor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tailor_expertise_tailor")
    )
    private TailorEntity tailor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "expertise_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tailor_expertise_expertise")
    )
    private ExpertiseEntity expertise;

    protected TailorExpertiseEntity() {
    }
}
