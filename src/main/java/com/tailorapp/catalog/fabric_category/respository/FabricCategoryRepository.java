package com.tailorapp.catalog.fabric_category.respository;

import com.tailorapp.catalog.fabric_category.dto.ArticleFabricCategoryDTO;
import com.tailorapp.catalog.fabric_category.entity.ArticleFabricCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricCategoryRepository extends JpaRepository<ArticleFabricCategory, Long> {

    @Query(
            value = """
            SELECT
                a.article_id,
                a.article_name,
                a.image_path,
                fc.fabric_category_id,
                fc.name AS fabric_category,
                fc.image_path AS fabric_cat_image_path
            FROM tailor.article_fabric_category afc
            JOIN tailor.articles a
                ON afc.article_id = a.article_id
            JOIN tailor.fabric_categories fc
                ON afc.fabric_category_id = fc.fabric_category_id
            WHERE a.article_id = :articleId
              AND a.is_active = 'Y'
            ORDER BY fc.fabric_category_id
        """,
            nativeQuery = true
    )
    List<ArticleFabricCategoryDTO> getFabricCatByArticleId(@Param("articleId") Long articleId);



}
