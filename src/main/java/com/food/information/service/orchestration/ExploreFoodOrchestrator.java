package com.food.information.service.orchestration;

import com.food.information.service.domain.ExploreFoodFinder;
import com.food.information.service.domain.model.ExploreFood;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExploreFoodOrchestrator {
    private final ExploreFoodFinder exploreFoodFinder;

    public ExploreFoodOrchestrator(ExploreFoodFinder exploreFoodFinder) {
        this.exploreFoodFinder = exploreFoodFinder;
    }

    public List<ExploreFood> getFood() {
        return exploreFoodFinder.findFood();
    }
}
