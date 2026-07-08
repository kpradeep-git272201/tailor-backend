package com.tailorapp.tailor.tailor.repository;

import com.tailorapp.tailor.tailor.entity.TailorArticleRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TailorArticleRateRepository
        extends JpaRepository<TailorArticleRate,Long> {

    List<TailorArticleRate>
    findByTailor_TailorId(Long tailorId);

}
