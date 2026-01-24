package com.tailorapp.catalog.article.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "articles", schema = DatabaseConstants.MASTER)
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="article_id")
    private Long articleId;
    @Column(name = "article_name")
    private String articleName;
    @Column(name = "image_path")
    private String imagePath;
    @Column(columnDefinition = "jsonb")
    private String profileDetails;

    public String getProfileDetails() {
        return profileDetails;
    }

    public void setProfileDetails(String profileDetails) {
        this.profileDetails = profileDetails;
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
