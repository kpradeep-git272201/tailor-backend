package com.tailorapp.catalog.fabric.service;

import com.tailorapp.catalog.fabric.dto.FabricColorResponseDTO;
import com.tailorapp.catalog.fabric.dto.FabricWithCategoryDTO;
import com.tailorapp.catalog.fabric.dto.FabricWithPriceDTO;
import com.tailorapp.catalog.fabric.projection.FabricCatalogProjection;
import com.tailorapp.catalog.fabric.projection.FabricColorProjection;

import java.util.List;

public interface FabricService {

    public List<FabricWithCategoryDTO> getFabricByFabCatId(Long fabricCategoryId);
    public List<FabricWithPriceDTO> fabricCategories();
    public FabricWithPriceDTO getFabricsWithPriceByFabricId(Long fabricId);
    public List<FabricCatalogProjection> getFabricCatalog();

    public List<FabricColorResponseDTO> getColorsByFabricId(Long fabricId);
}
