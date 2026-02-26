package com.tailorapp.master.service.imple;

import com.tailorapp.master.dto.FabricColorDTO;
import com.tailorapp.master.entity.FabricColorEntity;
import com.tailorapp.master.repository.MasterRespository;
import com.tailorapp.master.service.FabricColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class FabricColorServiceImpl implements FabricColorService {

    @Autowired
    private MasterRespository masterRespository;

    @Override
    public List<FabricColorDTO> getFabricColor(Integer fabricId) {
        List<FabricColorEntity> fabricColorByFabric = masterRespository.getFabricColorByFabricId(fabricId);
        return fabricColorByFabric.stream().map(fabricColorEntity -> new FabricColorDTO(fabricColorEntity.getColorId(), fabricColorEntity.getColorName(), fabricColorEntity.getHexCode())).toList();
    }
}
