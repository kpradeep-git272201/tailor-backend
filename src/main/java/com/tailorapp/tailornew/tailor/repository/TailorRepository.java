package com.tailorapp.tailornew.tailor.repository;

import com.tailorapp.tailornew.projection.TailorArticleRateProjection;
import com.tailorapp.tailornew.tailor.entity.TailorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TailorRepository extends JpaRepository<TailorEntity, Long> {

    Optional<TailorEntity> findByTailorIdAndDeletedFalse(Long tailorId);

    List<TailorEntity> findAllByDeletedFalseAndActiveTrueOrderByTailorIdDesc();

    List<TailorEntity> findTop10ByDeletedFalseAndActiveTrueOrderByAverageRatingDescReviewCountDesc();

    Page<TailorEntity> findAllByDeletedFalseAndActiveTrue(Pageable pageable);

    boolean existsByMobileNumberAndDeletedFalse(String mobileNumber);

    boolean existsByEmailAndDeletedFalse(String email);


    @Query(value = """
        SELECT
            tar.id AS id,
            tar.tailor_id AS tailorId,
            tar.article_id AS articleId,
            a.article_name AS articleName,
            tar.stitching_price AS stitchingPrice
        FROM tailor.tailor_article_rate tar
        LEFT JOIN tailor.articles a
            ON a.article_id = tar.article_id
        WHERE tar.tailor_id = :tailorId
        ORDER BY tar.stitching_price ASC
        """, nativeQuery = true)
    List<TailorArticleRateProjection> findByTailorId(@Param("tailorId") Long tailorId);

}
