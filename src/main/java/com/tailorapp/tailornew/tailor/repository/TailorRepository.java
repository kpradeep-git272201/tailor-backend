package com.tailorapp.tailornew.tailor.repository;

import com.tailorapp.tailornew.tailor.entity.TailorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

}
