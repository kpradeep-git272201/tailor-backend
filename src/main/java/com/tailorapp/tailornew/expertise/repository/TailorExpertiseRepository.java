package com.tailorapp.tailornew.expertise.repository;

import com.tailorapp.tailornew.expertise.entity.TailorExpertiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TailorExpertiseRepository extends JpaRepository<TailorExpertiseEntity, Long> {

    List<TailorExpertiseEntity> findAllByTailor_TailorIdAndDeletedFalse(Long tailorId);

    List<TailorExpertiseEntity> findAllByExpertise_ExpertiseIdAndDeletedFalse(Long expertiseId);

    Optional<TailorExpertiseEntity> findByTailor_TailorIdAndExpertise_ExpertiseIdAndDeletedFalse(
            Long tailorId,
            Long expertiseId
    );

    boolean existsByTailor_TailorIdAndExpertise_ExpertiseIdAndDeletedFalse(Long tailorId, Long expertiseId);
}
