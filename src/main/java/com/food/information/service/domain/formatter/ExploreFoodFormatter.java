package com.food.information.service.domain.formatter;

import com.food.information.service.domain.model.ExploreFood;
import com.food.information.service.domain.seo.SeoUrlBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExploreFoodFormatter {
    private final SeoUrlBuilder seoUrlBuilder;

    public ExploreFoodFormatter(SeoUrlBuilder seoUrlBuilder) {
        this.seoUrlBuilder = seoUrlBuilder;
    }

    public List<ExploreFood> formatFood(List<ExploreFood> exploreFoods) {
        exploreFoods.forEach(exploreFood -> exploreFood.setUrl(seoUrlBuilder.buildUrl(exploreFood.getFoodId(), exploreFood.getFoodDescription())));

        return exploreFoods;
    }
}
