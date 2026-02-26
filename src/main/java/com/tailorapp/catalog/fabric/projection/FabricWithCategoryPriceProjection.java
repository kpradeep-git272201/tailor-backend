package com.tailorapp.catalog.fabric.projection;

// For category + fabrics
public interface FabricWithCategoryPriceProjection extends BaseFabricProjection {
    Long getFabricCategoryId();
    String getCategoryName();
    String getCategoryDescription();
    String getCategoryImage();
    Boolean getIsActive();
    Character getIsDeleted();
    String getFabricImage();
}
