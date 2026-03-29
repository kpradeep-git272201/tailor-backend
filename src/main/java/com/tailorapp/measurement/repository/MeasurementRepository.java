package com.tailorapp.measurement.repository;

import com.tailorapp.measurement.entity.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {

    List<MeasurementEntity> findByUserId(Long userId);

    Optional<MeasurementEntity> findByUserIdAndIsDefaultTrue(Long userId);

    List<MeasurementEntity> findByUserIdOrderByIsDefaultDescCreatedAtDesc(Long userId);
}
