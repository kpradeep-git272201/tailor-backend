package com.tailorapp.catalog.article.controller;

import com.tailorapp.catalog.article.dto.ArticleDTO;
import com.tailorapp.catalog.article.service.ArticleService;
import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.common.response.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/catalog/api/v1/article")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    // constructor injection (preferred)
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/test")
    public String getTest() {
        return "Catalog controller works-1!";
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ArticleDTO>>> getArticle() {

        List<ArticleDTO> articles = articleService.getArticle();

        if (articles == null || articles.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No articles found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Articles fetched successfully", articles, articles.size())
        );
    }
}
