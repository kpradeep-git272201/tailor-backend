package com.tailorapp.tailor.tailor.controller;

import com.tailorapp.catalog.article.dto.ArticleDTO;
import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.tailor.tailor.service.TailorService;
import com.tailorapp.tailor.tailor.tailorDto.TailorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api/v1")

@RestController
public class TailorController {

    private final TailorService tailorService;
    public TailorController(TailorService  tailorService){
        this.tailorService=tailorService;
    }

    @GetMapping("/test")
    public String test(){
        return "Last updated on 24-JAN-2026";
    }
    @GetMapping("/tailors")
    public ResponseEntity<ApiResponse<List<TailorDTO>>> getTailors(){
        List<TailorDTO> tailors = tailorService.getTailors();
        if (tailors == null || tailors.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No Tailor found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Tailors fetched successfully", tailors, tailors.size())
        );
    }

    @GetMapping("/tailor/{tailorId}")
    public String getTailor(@PathVariable Long tailorId){
        return "Get Tailor by tailorId";
    }
}
