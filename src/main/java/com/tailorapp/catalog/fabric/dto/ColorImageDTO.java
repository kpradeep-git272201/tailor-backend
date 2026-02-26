package com.tailorapp.catalog.fabric.dto;

public class ColorImageDTO {

    private String imageUrl;

    public ColorImageDTO(String imageUrl) {

        this.imageUrl = imageUrl;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
