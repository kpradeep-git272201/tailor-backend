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


    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public TailorEntity getTailor() {
        return tailor;
    }

    public void setTailor(TailorEntity tailor) {
        this.tailor = tailor;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
