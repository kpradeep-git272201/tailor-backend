package com.tailorapp.master.entity;


import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "fabric_colors", schema = DatabaseConstants.TAILOR)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Integer colorId;
    @Column(name = "color_name")
    private String colorName;
    @Column(name = "hex_code")
    private String hexCode;

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }
}
