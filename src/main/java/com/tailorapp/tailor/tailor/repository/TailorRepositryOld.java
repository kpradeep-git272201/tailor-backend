package com.tailorapp.tailor.tailor.repository;

import com.tailorapp.tailor.tailor.entity.TailorEntityOld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TailorRepositryOld extends JpaRepository<TailorEntityOld, Long> {
}
