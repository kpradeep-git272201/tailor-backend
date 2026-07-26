package com.tailorapp.tailornew.expertise.repository;

import com.tailorapp.tailornew.expertise.entity.ExpertiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertiseRepository extends JpaRepository<ExpertiseEntity, Long> {

    Optional<ExpertiseEntity> findByExpertiseNameIgnoreCaseAndDeletedFalse(String expertiseName);

    List<ExpertiseEntity> findAllByDeletedFalseAndActiveTrueOrderByExpertiseNameAsc();
}
