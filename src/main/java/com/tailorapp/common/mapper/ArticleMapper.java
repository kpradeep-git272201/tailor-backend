package com.tailorapp.common.mapper;

import com.tailorapp.catalog.article.dto.ArticleDTO;
import com.tailorapp.catalog.article.dto.UpdateArticleRequest;
import com.tailorapp.catalog.article.entity.ArticleEntity;
import org.mapstruct.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface ArticleMapper {
    ArticleDTO toDto(ArticleEntity entity);
    List<ArticleDTO> toDtoList(List<ArticleEntity> entities);
    ArticleEntity toEntity(ArticleDTO dto);
    List<ArticleEntity> toEntityList(List<ArticleDTO> dtoList);
    /* ================= UPDATE (PATCH) ================= */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(
            UpdateArticleRequest dto,
            @MappingTarget ArticleEntity entity
    );
}
