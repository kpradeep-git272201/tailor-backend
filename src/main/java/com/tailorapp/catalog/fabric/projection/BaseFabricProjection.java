package com.tailorapp.catalog.fabric.projection;

import java.math.BigDecimal;

public interface BaseFabricProjection {
    Long getFabricId();
    String getFabricName();
    BigDecimal getPricePerMeter();
    Integer getStockQty();
}
