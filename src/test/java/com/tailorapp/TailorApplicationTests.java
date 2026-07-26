package com.tailorapp;

import com.tailorapp.tailor.projection.ArticleRateProjection;
import com.tailorapp.tailor.rates.ArticleRateRepository;
import com.tailorapp.tailor.rates.ArticleRateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TailorApplicationTests {
	/*private final ArticleRateService articleRateService;
	private final ArticleRateRepository articleRateRepository;

	public TailorApplicationTests(ArticleRateService articleRateService, ArticleRateRepository articleRateRepository){
		this.articleRateService=articleRateService;
		this.articleRateRepository=articleRateRepository;
	}*/
	@Test
	void contextLoads() {
	}

/*	@Test
	void articleRatesTest(){
		List<ArticleRateProjection> articleRateProjectionList= articleRateRepository.findAllArticleRates(1L);
		System.out.println(articleRateProjectionList);
	}*/


}
