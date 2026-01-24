package com.tailorapp.tailor.tailor.service.impl;

import com.tailorapp.common.mapper.TailorMapper;
import com.tailorapp.tailor.tailor.entity.TailorEntity;
import com.tailorapp.tailor.tailor.repository.TailorRepositry;
import com.tailorapp.tailor.tailor.service.TailorService;
import com.tailorapp.tailor.tailor.tailorDto.TailorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailorServiceImple implements TailorService {

    private final TailorRepositry tailorRepositry;
    private final TailorMapper tailorMapper;
    public TailorServiceImple(TailorRepositry tailorRepositry, TailorMapper tailorMapper){
        this.tailorRepositry = tailorRepositry;
        this.tailorMapper = tailorMapper;
    }
    @Override
    public List<TailorDTO> getTailors() {
        List<TailorEntity> tailorEntity = this.tailorRepositry.findAll();
        return tailorEntity.stream()
                .map(tailorMapper::toDto)
                .toList();
    }

    @Override
    public TailorDTO getTailor() {
        return null;
    }
}
