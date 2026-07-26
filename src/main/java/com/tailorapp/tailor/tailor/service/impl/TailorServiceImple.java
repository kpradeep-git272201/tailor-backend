package com.tailorapp.tailor.tailor.service.impl;

import com.tailorapp.common.mapper.TailorMapper;
import com.tailorapp.tailor.tailor.entity.TailorArticleRate;
import com.tailorapp.tailor.tailor.entity.TailorEntityOld;
import com.tailorapp.tailor.tailor.repository.TailorRepositryOld;
import com.tailorapp.tailor.tailor.repository.TailorArticleRateRepository;
import com.tailorapp.tailor.tailor.service.TailorService;
import com.tailorapp.tailor.tailor.tailorDto.TailorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailorServiceImple implements TailorService {

    private final TailorRepositryOld tailorRepositryOld;
    private final TailorMapper tailorMapper;
    private final TailorArticleRateRepository tailorArticleRateRepository;
    public TailorServiceImple(TailorRepositryOld tailorRepositryOld, TailorMapper tailorMapper, TailorArticleRateRepository tailorArticleRateRepository){
        this.tailorRepositryOld = tailorRepositryOld;
        this.tailorMapper = tailorMapper;
        this.tailorArticleRateRepository=tailorArticleRateRepository;
    }
    @Override
    public List<TailorDTO> getTailors() {
        List<TailorEntityOld> tailorEntityOld = this.tailorRepositryOld.findAll();
        return tailorEntityOld.stream()
                .map(tailorMapper::toDto)
                .toList();
    }

    @Override
    public TailorDTO getTailor() {
        return null;
    }

    @Override
    public List<TailorArticleRate> getRates(Long tailorId) {
        return tailorArticleRateRepository.findByTailor_TailorId(tailorId);
    }
}
