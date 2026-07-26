package com.tailorapp.tailor.projection;

import java.math.BigDecimal;

public interface ArticleRateProjection {

    Long getId();

    Long getTailorId();

    Long getArticleId();

    BigDecimal getStitchingPrice();
}
