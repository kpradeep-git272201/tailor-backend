package com.tailorapp.catalog.fabric_category.service.impl;

import com.tailorapp.catalog.fabric_category.dto.ArticleFabricCategoryDTO;
import com.tailorapp.catalog.fabric_category.respository.FabricCategoryRepository;
import com.tailorapp.catalog.fabric_category.service.FabricCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricCategoryServiceImpl implements FabricCategoryService {


    private final FabricCategoryRepository fabricCategoryRepository;

    public FabricCategoryServiceImpl(FabricCategoryRepository fabricCategoryRepository) {
        this.fabricCategoryRepository = fabricCategoryRepository;
    }

    @Override
    public List<ArticleFabricCategoryDTO> getFabricCatByArticleId(Long articleId) {
        return this.fabricCategoryRepository.getFabricCatByArticleId(articleId);
    }
}
