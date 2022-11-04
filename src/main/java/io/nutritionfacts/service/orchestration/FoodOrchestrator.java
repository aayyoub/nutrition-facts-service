package io.nutritionfacts.service.orchestration;

import io.nutritionfacts.service.domain.FoodFinder;
import io.nutritionfacts.service.domain.FoodResolver;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.api.controller.GetFoodRequest;
import org.springframework.stereotype.Component;

@Component
public class FoodOrchestrator {
    private final FoodResolver foodResolver;
    private final FoodFinder foodFinder;

    public FoodOrchestrator(FoodResolver foodResolver, FoodFinder foodFinder) {
        this.foodResolver = foodResolver;
        this.foodFinder = foodFinder;
    }

    public Food getFood(GetFoodRequest getFoodRequest) {
        String foodId = foodResolver.resolveFood(getFoodRequest.getFoodName());

        return foodFinder.findFood(foodId, getFoodRequest.getServingSize());
    }
}
