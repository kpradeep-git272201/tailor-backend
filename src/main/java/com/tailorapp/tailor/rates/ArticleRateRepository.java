package com.tailorapp.tailor.rates;

import com.tailorapp.tailor.projection.ArticleRateProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRateRepository extends JpaRepository<ArticleRateEntity, Long> {

    @Query("""
            SELECT
                a.id AS id,
                a.tailorId AS tailorId,
                a.articleId AS articleId,
                a.stitchingPrice AS stitchingPrice
            FROM ArticleRateEntity a
            WHERE a.tailorId = :tailorId
            """)
    List<ArticleRateProjection> findAllArticleRates(@Param("tailorId") Long tailorId);
}