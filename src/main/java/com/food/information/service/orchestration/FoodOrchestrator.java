package com.food.information.service.orchestration;

import com.food.information.service.api.model.GetFoodRequest;
import com.food.information.service.domain.FoodFinder;
import com.food.information.service.domain.FoodResolver;
import com.food.information.service.domain.model.Food;
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
