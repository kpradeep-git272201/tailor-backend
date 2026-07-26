package com.tailorapp.tailornew.tailor.service;

import com.tailorapp.tailornew.tailor.dto.TailorResponseDto;

import java.util.List;


public interface TailorService {

    TailorResponseDto createTailor(TailorResponseDto tailorDto);
    List<TailorResponseDto> getAllTailors();

}