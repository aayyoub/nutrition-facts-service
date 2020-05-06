package io.nutritionfacts.api.orchestration;

import io.nutritionfacts.api.api.model.GetFoodRequest;
import io.nutritionfacts.api.domain.FoodFinder;
import io.nutritionfacts.api.domain.FoodResolver;
import io.nutritionfacts.api.domain.model.Food;
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
