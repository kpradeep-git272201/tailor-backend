package com.tailorapp.catalog.fabric_category.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles", schema = DatabaseConstants.TAILOR)
public class Article {
    @Id
    @Column(name = "article_id")
    private Long articleId;
    @Column(name = "article_name")
    private String articleName;
    @Column(name = "image_path")
    private String imagePath;
}
