package com.tailorapp.tailornew.review.repository;

import com.tailorapp.tailornew.review.entity.TailorReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TailorReviewRepository extends JpaRepository<TailorReviewEntity, Long> {

    List<TailorReviewEntity> findAllByTailor_TailorIdAndDeletedFalseOrderByCreatedAtDesc(Long tailorId);

    Optional<TailorReviewEntity> findByTailor_TailorIdAndUser_UserIdAndDeletedFalse(Long tailorId, Long userId);

    long countByTailor_TailorIdAndDeletedFalse(Long tailorId);

    @Query("""
           select coalesce(avg(r.rating), 0)
           from TailorReviewEntity r
           where r.tailor.tailorId = :tailorId
             and r.deleted = false
           """)
    Double getAverageRatingByTailorId(@Param("tailorId") Long tailorId);
}
