package com.tailorapp.tailor.dto;

import java.math.BigDecimal;

import java.util.List;

public class ArticleRatsDTO {

    private Long tailorId;
    private List<RateDTO> rates;

    public ArticleRatsDTO() {
    }

    public ArticleRatsDTO(Long tailorId, List<RateDTO> rates) {
        this.tailorId = tailorId;
        this.rates = rates;
    }

    // Getter & Setter


    public Long getTailorId() {
        return tailorId;
    }

    public void setTailorId(Long tailorId) {
        this.tailorId = tailorId;
    }

    public List<RateDTO> getRates() {
        return rates;
    }

    public void setRates(List<RateDTO> rates) {
        this.rates = rates;
    }
}