package com.food.information.service.orchestration;

import com.food.information.service.domain.FoodFinder;
import com.food.information.service.domain.model.FoodNutritionalDetails;
import org.springframework.stereotype.Component;

@Component
public class FoodOrchestrator {
    private final FoodFinder foodFinder;

    public FoodOrchestrator(FoodFinder foodFinder) {
        this.foodFinder = foodFinder;
    }

    public FoodNutritionalDetails getFood(String foodId) {
        return foodFinder.findFood(foodId);
    }
}
