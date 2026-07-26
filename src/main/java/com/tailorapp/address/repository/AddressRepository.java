package com.tailorapp.address.repository;

import com.tailorapp.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findByUserId(Long userId);

    Optional<AddressEntity> findByUserIdAndIsDefaultTrue(Long userId);

    List<AddressEntity> findByUserIdOrderByIsDefaultDescCreatedAtDesc(Long userId);
}
