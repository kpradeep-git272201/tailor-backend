package com.tailorapp.catalog.fabric.dto;

import java.util.List;

public class FabricColorResponseDTO {
    private Long colorId;
    private String colorName;
    private String hexCode;
    private List<ColorImageDTO> images;

    public FabricColorResponseDTO(Long colorId,
                                  String colorName,
                                  String hexCode,
                                  List<ColorImageDTO> images) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.hexCode = hexCode;
        this.images = images;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
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

    public List<ColorImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ColorImageDTO> images) {
        this.images = images;
    }
}
