package com.tailorapp.catalog.fabric_category.controller;


import com.tailorapp.catalog.article.dto.ArticleDTO;
import com.tailorapp.catalog.fabric_category.dto.ArticleFabricCategoryDTO;
import com.tailorapp.catalog.fabric_category.service.FabricCategoryService;
import com.tailorapp.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class FabCatController {

    @Autowired
    private FabricCategoryService fabricCategoryService;

    @GetMapping("/articles/{articleId}/fabric-categories")
    public ResponseEntity<ApiResponse<List<ArticleFabricCategoryDTO>>>getFabricCatByArticleId(@PathVariable Long articleId){
        List<ArticleFabricCategoryDTO> fabricCatByArticleId = this.fabricCategoryService.getFabricCatByArticleId(articleId);
        if (fabricCatByArticleId == null || fabricCatByArticleId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Article not found", "ARTICLE_NOT_FOUND"));
        }

        return ResponseEntity.ok(
                ApiResponse.success("Fabric Category fetched successfully", fabricCatByArticleId, fabricCatByArticleId.size())
        );
    }


    @GetMapping("/articles/fabric-categories/{fabCatId}")
    public String getFabricBYFabCatId(@PathVariable Long fabCatId){
        return ""+fabCatId;
    }
}
