package com.tailorapp.tailornew.address.repository;

import com.tailorapp.tailornew.address.entity.TailorAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TailorAddressRepository extends JpaRepository<TailorAddressEntity, Long> {

    Optional<TailorAddressEntity> findByTailor_TailorIdAndDeletedFalse(Long tailorId);
}
