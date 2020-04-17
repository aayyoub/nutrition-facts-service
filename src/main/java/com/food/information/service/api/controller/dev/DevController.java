package com.food.information.service.api.controller.dev;

import com.food.information.service.dataaccess.elasticsearch.entity.SearchTermEntity;
import com.food.information.service.dataaccess.elasticsearch.repository.SearchTermRepository;
import com.food.information.service.dataaccess.jpa.entity.FoodNameMappingEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.seo.SeoUrlBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {
    private final FoodRepository foodRepository;
    private final SearchTermRepository searchTermRepository;
    private final SeoUrlBuilder seoUrlBuilder;

    public DevController(FoodRepository foodRepository, SearchTermRepository searchTermRepository, SeoUrlBuilder seoUrlBuilder) {
        this.foodRepository = foodRepository;
        this.searchTermRepository = searchTermRepository;
        this.seoUrlBuilder = seoUrlBuilder;
    }

    @CrossOrigin
    @GetMapping("/buildSearchIndex")
    public void buildSearchIndex() {
        foodRepository.getAllLinks().forEach((searchTerm) -> {
                    SearchTermEntity searchTermEntity = new SearchTermEntity();
                    searchTermEntity.setId(searchTerm.getFoodDescriptionId());
                    searchTermEntity.setSearchTerm(searchTerm.getLongDescription());
                    searchTermRepository.save(searchTermEntity);
                }
        );
    }

    @CrossOrigin
    @GetMapping("/buildPageMappings")
    public void buildPageMappings() {
        foodRepository.getAllLinks().forEach((searchTerm) -> {
                    try {
                        FoodNameMappingEntity foodNameMappingEntity = new FoodNameMappingEntity();
                        foodNameMappingEntity.setFoodName(seoUrlBuilder.formatDescription(searchTerm.getLongDescription()));
                        foodNameMappingEntity.setFoodId(searchTerm.getFoodDescriptionId());
                        foodRepository.save(foodNameMappingEntity);
                    } catch (Exception ignored) {
                    }
                }
        );
    }
}
