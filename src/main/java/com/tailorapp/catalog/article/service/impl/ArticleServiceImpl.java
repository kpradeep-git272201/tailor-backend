package com.tailorapp.catalog.article.service.impl;

import com.tailorapp.catalog.article.dto.ArticleDTO;
import com.tailorapp.catalog.article.entity.ArticleEntity;
import com.tailorapp.catalog.article.repository.ArticleRepository;
import com.tailorapp.catalog.article.service.ArticleService;
import com.tailorapp.common.mapper.ArticleMapper;
import com.tailorapp.common.mapper.TailorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public List<ArticleDTO> getArticle() {
        List<ArticleEntity> entities = articleRepository.findAll();

        return articleMapper.toDtoList(entities);
    }
}
