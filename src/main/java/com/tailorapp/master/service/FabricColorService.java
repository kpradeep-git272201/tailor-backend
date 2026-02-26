package com.tailorapp.master.service;

import com.tailorapp.master.dto.FabricColorDTO;

import java.util.List;

public interface FabricColorService {

    public List<FabricColorDTO> getFabricColor(Integer fabricId);
}
