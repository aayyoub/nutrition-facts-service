package io.nutritionfacts.service.orchestration;

import io.nutritionfacts.service.api.controller.GetFoodRequest;
import io.nutritionfacts.service.domain.FoodFinder;
import io.nutritionfacts.service.domain.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodOrchestrator {
    private final FoodFinder foodFinder;

    public FoodOrchestrator(FoodFinder foodFinder) {
        this.foodFinder = foodFinder;
    }

    public Food getFood(GetFoodRequest request) {
        return foodFinder.findFood(
                request.getFoodName(),
                request.getServingSize()
        );
    }
}
