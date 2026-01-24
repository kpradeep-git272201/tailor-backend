package com.tailorapp.catalog.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleRequest {
    private String articleName;
    private String imagePath;

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
