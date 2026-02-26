package com.tailorapp.catalog.fabric_category.dto;

import java.io.Serializable;

public class ArticleFabricCategoryDTO implements Serializable {

    private Long articleId;
    private String articleName;
    private String articleImagePath;

    private Long fabricCategoryId;
    private String fabricCategoryName;
    private String fabricCategoryImagePath;

    // DEFAULT CONSTRUCTOR (MANDATORY for JPA / Jackson)
    public ArticleFabricCategoryDTO() {
    }

    // JPQL "new DTO(...)" CONSTRUCTOR (ORDER MATTERS)
    public ArticleFabricCategoryDTO(
            Long articleId,
            String articleName,
            String articleImagePath,
            Long fabricCategoryId,
            String fabricCategoryName,
            String fabricCategoryImagePath
    ) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleImagePath = articleImagePath;
        this.fabricCategoryId = fabricCategoryId;
        this.fabricCategoryName = fabricCategoryName;
        this.fabricCategoryImagePath = fabricCategoryImagePath;
    }

    // ---------- GETTERS & SETTERS ----------

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleImagePath() {
        return articleImagePath;
    }

    public void setArticleImagePath(String articleImagePath) {
        this.articleImagePath = articleImagePath;
    }

    public Long getFabricCategoryId() {
        return fabricCategoryId;
    }

    public void setFabricCategoryId(Long fabricCategoryId) {
        this.fabricCategoryId = fabricCategoryId;
    }

    public String getFabricCategoryName() {
        return fabricCategoryName;
    }

    public void setFabricCategoryName(String fabricCategoryName) {
        this.fabricCategoryName = fabricCategoryName;
    }

    public String getFabricCategoryImagePath() {
        return fabricCategoryImagePath;
    }

    public void setFabricCategoryImagePath(String fabricCategoryImagePath) {
        this.fabricCategoryImagePath = fabricCategoryImagePath;
    }
}

