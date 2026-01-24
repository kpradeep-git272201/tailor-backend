package com.tailorapp.tailor.tailor.service;

import com.tailorapp.tailor.tailor.tailorDto.TailorDTO;
import java.util.List;
public interface TailorService {
    public List<TailorDTO> getTailors();

    public TailorDTO getTailor();
}
