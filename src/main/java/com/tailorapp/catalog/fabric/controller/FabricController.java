package com.tailorapp.catalog.fabric.controller;

import com.tailorapp.catalog.fabric.dto.FabricColorResponseDTO;
import com.tailorapp.catalog.fabric.dto.FabricWithCategoryDTO;
import com.tailorapp.catalog.fabric.dto.FabricWithPriceDTO;
import com.tailorapp.catalog.fabric.projection.FabricCatalogProjection;
import com.tailorapp.catalog.fabric.projection.FabricColorProjection;
import com.tailorapp.catalog.fabric.service.FabricService;
import com.tailorapp.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1/fabric")
@RestController
public class FabricController {
    private final FabricService fabricService;
    public FabricController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping("/catalog")
    public ResponseEntity<List<FabricCatalogProjection>> getCatalog() {
        return ResponseEntity.ok(fabricService.getFabricCatalog());
    }
    @GetMapping("/fabric-categories/{fabricCategoryId}")
    public ResponseEntity<ApiResponse<List<FabricWithCategoryDTO>>> getFabricBYFabCatId(@PathVariable Long fabricCategoryId){
        List<FabricWithCategoryDTO> fabricByFabCatId = this.fabricService.getFabricByFabCatId(fabricCategoryId);
        if (fabricByFabCatId == null || fabricByFabCatId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Fabric not found", "FABRIC_NOT_FOUND"));
        }

        return ResponseEntity.ok(
                ApiResponse.success("Fabric fetched successfully", fabricByFabCatId, fabricByFabCatId.size())
        );
    }
    @GetMapping("/fabric-categories")
    public ResponseEntity<ApiResponse<List<FabricWithPriceDTO>>> getFabricCateoris(){
        List<FabricWithPriceDTO> fabricCategories = this.fabricService.fabricCategories();
        if (fabricCategories == null || fabricCategories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Fabric not found", "FABRIC_NOT_FOUND"));
        }
        return ResponseEntity.ok(
                ApiResponse.success("Fabric fetched successfully", fabricCategories, fabricCategories.size())
        );
    }
    @GetMapping("/fabric-category/{fabricId}")
    public ResponseEntity<ApiResponse<FabricWithPriceDTO>> getFabricsWithPriceByFabricId(@PathVariable Long fabricId){
        if (fabricId == null) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error(
                            "fabricId is required",
                            "FABRIC_ID_MISSING"
                    ));
        }

        FabricWithPriceDTO fabricCategories = this.fabricService.getFabricsWithPriceByFabricId(fabricId);
        if (fabricCategories == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Fabric not found", "FABRIC_NOT_FOUND"));
        }
        return ResponseEntity.ok(
                ApiResponse.success("Fabric fetched successfully", fabricCategories, Arrays.asList(fabricCategories).size())
        );
    }

    @GetMapping("/{fabricId}/colors")
    public ResponseEntity<ApiResponse<List<FabricColorResponseDTO>>> getFabricColorByFabricId(
            @PathVariable Long fabricId) {

        if (fabricId == null) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error(
                            "fabricId is required",
                            "FABRIC_ID_MISSING"
                    ));
        }

        List<FabricColorResponseDTO> colors =
                fabricService.getColorsByFabricId(fabricId);

        if (colors == null || colors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(
                            "Colors not found for given fabric",
                            "COLOR_NOT_FOUND"
                    ));
        }

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Fabric colors fetched successfully",
                        colors,
                        colors.size()
                )
        );
    }
}
