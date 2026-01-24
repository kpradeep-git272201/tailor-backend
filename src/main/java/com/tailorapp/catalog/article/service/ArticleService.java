package com.tailorapp.catalog.article.service;

import com.tailorapp.catalog.article.dto.ArticleDTO;
import com.tailorapp.catalog.article.entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    public List<ArticleDTO> getArticle();
}
