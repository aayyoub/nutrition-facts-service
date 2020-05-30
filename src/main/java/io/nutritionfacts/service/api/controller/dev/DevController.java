package io.nutritionfacts.api.api.controller.dev;

import io.nutritionfacts.api.dataaccess.elasticsearch.entity.SearchTermEntity;
import io.nutritionfacts.api.dataaccess.elasticsearch.repository.SearchTermRepository;
import io.nutritionfacts.api.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.api.dataaccess.jpa.repository.FoodRepository;
import io.nutritionfacts.api.domain.seo.SeoUrlBuilder;
import io.nutritionfacts.api.util.dev.SitemapBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {
    private final SitemapBuilder sitemapBuilder;
    private final FoodRepository foodRepository;
    private final SearchTermRepository searchTermRepository;
    private final SeoUrlBuilder seoUrlBuilder;

    public DevController(SitemapBuilder sitemapBuilder, FoodRepository foodRepository, SearchTermRepository searchTermRepository, SeoUrlBuilder seoUrlBuilder) {
        this.sitemapBuilder = sitemapBuilder;
        this.foodRepository = foodRepository;
        this.searchTermRepository = searchTermRepository;
        this.seoUrlBuilder = seoUrlBuilder;
    }

    @CrossOrigin
    @GetMapping("/buildSitemap")
    public void buildSitemap() throws Exception {
        sitemapBuilder.buildSitemap();
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
                        foodNameMappingEntity.setFoodName(seoUrlBuilder.getFoodName(searchTerm.getLongDescription()));
                        foodNameMappingEntity.setFoodId(searchTerm.getFoodDescriptionId());
                        foodRepository.save(foodNameMappingEntity);
                    } catch (Exception ignored) {
                    }
                }
        );
    }
}
