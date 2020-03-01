package com.food.information.service.domain;

import com.food.information.service.domain.formatter.ExploreFoodFormatter;
import com.food.information.service.domain.model.ExploreFood;
import com.food.information.service.services.ExploreFoodService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExploreFoodFinder {
    private final ExploreFoodService exploreFoodService;
    private final ExploreFoodFormatter exploreFoodFormatter;

    public ExploreFoodFinder(ExploreFoodService exploreFoodService, ExploreFoodFormatter exploreFoodFormatter) {
        this.exploreFoodService = exploreFoodService;
        this.exploreFoodFormatter = exploreFoodFormatter;
    }

    public List<ExploreFood> findFood() {
        List<ExploreFood> food = exploreFoodService.getFood();

        return exploreFoodFormatter.formatFood(food);
    }
}
