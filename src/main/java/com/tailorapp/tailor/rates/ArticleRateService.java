package com.tailorapp.tailor.rates;

import com.tailorapp.common.exception.ResourceNotFoundException;
import com.tailorapp.tailor.dto.ArticleRatsDTO;
import com.tailorapp.tailor.dto.RateDTO;
import com.tailorapp.tailor.projection.ArticleRateProjection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArticleRateService {
    private final ArticleRateRepository articleRateRepository;

    public ArticleRateService(ArticleRateRepository articleRateRepository){
        this.articleRateRepository=articleRateRepository;
    }

    public List<ArticleRatsDTO> findAllArticleRatesByTailor(Long tailorId){
        List<ArticleRateProjection> articleRates = articleRateRepository.findAllArticleRates(tailorId);

        if (articleRates.isEmpty()) {
            throw new ResourceNotFoundException( "No article rates found for tailor id : " + tailorId);
        }
        Map<Long, List<RateDTO>> grouped = articleRates.stream()
                .collect(Collectors.groupingBy(
                        ArticleRateProjection::getTailorId,
                        Collectors.mapping(
                                p -> new RateDTO(
                                        p.getArticleId(),
                                        p.getStitchingPrice()
                                ),
                                Collectors.toList()
                        )
                ));

        return grouped.entrySet()
                .stream()
                .map(entry -> new ArticleRatsDTO(
                        entry.getKey(),
                        entry.getValue()
                ))
                .toList();
    }
}
