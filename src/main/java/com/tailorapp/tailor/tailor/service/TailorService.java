package com.tailorapp.tailor.tailor.service;

import com.tailorapp.tailor.tailor.entity.TailorArticleRate;
import com.tailorapp.tailor.tailor.tailorDto.TailorDTO;
import java.util.List;
public interface TailorService {
    public List<TailorDTO> getTailors();

    public TailorDTO getTailor();

    public List<TailorArticleRate> getRates(Long tailorId);
}
