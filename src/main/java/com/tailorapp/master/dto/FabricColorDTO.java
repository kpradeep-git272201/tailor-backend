package com.tailorapp.master.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class FabricColorDTO implements Serializable {
    private Integer colorId;
    private String colorName;
    private String hexCode;

    public FabricColorDTO(){}
    public FabricColorDTO(Integer colorId, String colorName, String hexCode) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.hexCode = hexCode;
    }

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
