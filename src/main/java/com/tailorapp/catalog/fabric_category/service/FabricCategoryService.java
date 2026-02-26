package com.tailorapp.catalog.fabric_category.service;

import com.tailorapp.catalog.fabric_category.dto.ArticleFabricCategoryDTO;

import java.util.List;

public interface FabricCategoryService {

    public List<ArticleFabricCategoryDTO> getFabricCatByArticleId(Long articleId);
}
