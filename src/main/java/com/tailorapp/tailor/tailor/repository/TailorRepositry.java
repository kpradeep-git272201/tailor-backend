package com.tailorapp.tailor.tailor.repository;

import com.tailorapp.tailor.tailor.entity.TailorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TailorRepositry extends JpaRepository<TailorEntity, Long> {
}
