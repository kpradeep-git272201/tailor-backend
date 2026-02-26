package com.tailorapp.catalog.fabric.service.impl;

import com.tailorapp.catalog.fabric.dto.ColorImageDTO;
import com.tailorapp.catalog.fabric.dto.FabricColorResponseDTO;
import com.tailorapp.catalog.fabric.dto.FabricWithCategoryDTO;
import com.tailorapp.catalog.fabric.dto.FabricWithPriceDTO;
import com.tailorapp.catalog.fabric.projection.FabricCatalogProjection;
import com.tailorapp.catalog.fabric.projection.FabricColorProjection;
import com.tailorapp.catalog.fabric.respository.FabricRepository;
import com.tailorapp.catalog.fabric.service.FabricService;
import com.tailorapp.catalog.fabric.projection.FabricWithCategoryPriceProjection;
import com.tailorapp.catalog.fabric.projection.FabricWithPriceProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FabricServiceImpl implements FabricService {


    @Autowired
    private final FabricRepository fabricRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public FabricServiceImpl(FabricRepository fabricRepository) {
        this.fabricRepository = fabricRepository;
    }


    @Override
    public List<FabricCatalogProjection> getFabricCatalog() {
        return fabricRepository.fetchFabricCatalog();
    }

    @Override
    public List<FabricColorResponseDTO> getColorsByFabricId(Long fabricId) {
        List<FabricColorProjection> flatList =
                fabricRepository.fetchColorsByFabricId(fabricId);

        if (flatList == null || flatList.isEmpty()) {
            return Collections.emptyList();
        }

        return flatList.stream()
                .collect(Collectors.groupingBy(
                        FabricColorProjection::getColorName
                ))
                .values()
                .stream()
                .map(colorGroup -> {

                    FabricColorProjection first = colorGroup.get(0);

                    // first non-null hexCode
                    String hexCode = colorGroup.stream()
                            .map(FabricColorProjection::getHexCode)
                            .filter(Objects::nonNull)
                            .findFirst()
                            .orElse(null);

                    List<ColorImageDTO> images = colorGroup.stream()
                            .map(FabricColorProjection::getColorImage)
                            .filter(Objects::nonNull)
                            .distinct()
                            .map(ColorImageDTO::new)
                            .collect(Collectors.toList());

                    return new FabricColorResponseDTO(
                            first.getColorId(),   // representative id
                            first.getColorName(),
                            hexCode,
                            images
                    );
                })
                .sorted(Comparator.comparing(FabricColorResponseDTO::getColorName))
                .collect(Collectors.toList());
    }


    @Override
    public List<FabricWithCategoryDTO> getFabricByFabCatId(Long fabricCategoryId) {
        List<FabricWithCategoryPriceProjection> byFabricCategoryFabricCategoryId = this.fabricRepository.findByFabricCategoryId(fabricCategoryId);
        return byFabricCategoryFabricCategoryId.stream()
                .map(r -> new FabricWithCategoryDTO(
                        r.getFabricCategoryId(),
                        r.getCategoryName(),
                        r.getCategoryDescription(),
                        r.getCategoryImage(),
                        r.getFabricId(),
                        r.getFabricName(),
                        r.getStockQty(),
                        r.getIsActive(),
                        r.getIsDeleted(),
                        r.getFabricImage()
                        ))
                        .toList();
    }

    @Override
    public List<FabricWithPriceDTO> fabricCategories() {
        List<FabricWithPriceProjection> fabricCategories = this.fabricRepository.getAllFabricsWithPrice();
        return fabricCategories.stream()
                .map(r -> new FabricWithPriceDTO(
                        r.getFabricId(),
                        r.getFabricName(),
                        r.getFabricCategoryId(),
                        r.getPricePerMeter(),
                        r.getStockQty(),
                        r.getIsActive(),
                        r.getIsDeleted(),
                        r.getImagePath(),
                        r.getCategoryName(),
                        r.getCategoryDescription()

                ))
                .toList();
    }

    @Override
    public FabricWithPriceDTO getFabricsWithPriceByFabricId(Long fabricId) {
        List<FabricWithPriceProjection> fabricCategories = this.fabricRepository.getFabricsWithPriceByFabricId(fabricId);
        return fabricCategories.stream()
                .map(r -> new FabricWithPriceDTO(
                        r.getFabricId(),
                        r.getFabricName(),
                        r.getFabricCategoryId(),
                        r.getPricePerMeter(),
                        r.getStockQty(),
                        r.getIsActive(),
                        r.getIsDeleted(),
                        r.getImagePath(),
                        r.getCategoryName(),
                        r.getCategoryDescription()

                ))
                .toList().get(0);
    }
}
