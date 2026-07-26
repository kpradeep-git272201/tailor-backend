package com.tailorapp.tailor.dto;

import java.math.BigDecimal;

public class RateDTO {

    private Long articleId;
    private BigDecimal stitchingPrice;

    public RateDTO(Long articleId, BigDecimal stitchingPrice) {
        this.articleId = articleId;
        this.stitchingPrice = stitchingPrice;
    }
    // getters & setters
    public Long getArticleId() {
        return articleId;
    }
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
    public BigDecimal getStitchingPrice() {
        return stitchingPrice;
    }
    public void setStitchingPrice(BigDecimal stitchingPrice) {
        this.stitchingPrice = stitchingPrice;
    }
}