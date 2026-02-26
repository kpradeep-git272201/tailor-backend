package com.tailorapp.catalog.fabric_category.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;

@Entity
@Table(name = "article_fabric_category", schema = DatabaseConstants.TAILOR)
public class ArticleFabricCategory {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "fabric_category_id")
    private FabricCategory fabricCategory;


    @Transient
    private Long articleId;

    @Transient
    private String articleName;

    @Transient
    private String articleImagePath;

    @Transient
    private Long fabricCategoryId;

    @Transient
    private String fabricCategoryName;

    @Transient
    private String fabricCategoryImagePath;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public FabricCategory getFabricCategory() {
        return fabricCategory;
    }

    public void setFabricCategory(FabricCategory fabricCategory) {
        this.fabricCategory = fabricCategory;
    }
}
