package com.tailorapp.tailornew.projection;

import java.math.BigDecimal;

public interface TailorArticleRateProjection {
    Long getId();

    Long getTailorId();

    Long getArticleId();

    String getArticleName();

    BigDecimal getStitchingPrice();
}
