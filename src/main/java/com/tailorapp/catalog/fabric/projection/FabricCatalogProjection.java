package com.tailorapp.catalog.fabric.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FabricCatalogProjection {
    /* ========== FABRIC ========== */
    Long getFabricId();
    String getFabricName();
    Long getFabricCategoryId();
    Integer getStockQty();
    Boolean getActiveFlag();
    String getIsDeleted();
    String getFabricImagePath();

    /* ========== CATEGORY ========== */
    String getCategoryName();
    String getCategoryDescription();
    String getCategoryImagePath();

    /* ========== TEXTURE ========== */
    String getTextureName();

    /* ========== PRICE ========== */
    BigDecimal getPricePerUnit();   // changed
    String getCurrency();
    LocalDate getValidFrom();
    LocalDate getValidTo();
    Boolean getPriceActive();

    /* ========== IMAGES ========== */
    String getFabricImage();
    Boolean getProfileImage();
    String getImageDescription();
    Long getImageCategoryId();
}
