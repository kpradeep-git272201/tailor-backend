package com.tailorapp.catalog.fabric.projection;

public interface FabricWithPriceProjection extends BaseFabricProjection {
    Integer getFabricCategoryId();
    Boolean getIsActive();
    Character getIsDeleted();
    String getImagePath();
    String getCategoryName();
    String getCategoryDescription();
}

