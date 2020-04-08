package com.food.information.service.orchestration;

import com.food.information.service.api.model.GetFoodRequest;
import com.food.information.service.domain.FoodFinder;
import com.food.information.service.domain.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodOrchestrator {
    private final FoodFinder foodFinder;

    public FoodOrchestrator(FoodFinder foodFinder) {
        this.foodFinder = foodFinder;
    }

    public Food getFood(GetFoodRequest getFoodRequest) {
        String foodId = getFoodRequest.getFoodId();
        Integer servingSize = getFoodRequest.getServingSize();

        return foodFinder.findFood(foodId, servingSize);
    }
}
