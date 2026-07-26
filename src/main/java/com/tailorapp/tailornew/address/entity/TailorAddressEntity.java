package com.tailorapp.tailornew.address.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import com.tailorapp.tailornew.BaseEntity;
import com.tailorapp.tailornew.tailor.entity.TailorEntity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "tailor_address",
        schema = DatabaseConstants.TAILOR,
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_tailor_address_tailor", columnNames = "tailor_id")
        }
)
@Setter
@Getter
public class TailorAddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "tailor_id",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(name = "fk_tailor_address_tailor")
    )
    private TailorEntity tailor;

    @Column(name = "address_line1", nullable = false, length = 255)
    private String addressLine1;

    @Column(name = "address_line2", length = 255)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "pincode", nullable = false, length = 10)
    private String pincode;

    @Column(name = "latitude", precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private BigDecimal longitude;

    @PrePersist
    public void prePersist() {

        if (country == null || country.isBlank()) {
            country = "India";
        }
    }

    protected TailorAddressEntity() {
    }
}
