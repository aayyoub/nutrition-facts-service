package com.food.information.service.domain;

import com.food.information.service.domain.formatter.FoodFormatter;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.FoodNutritionalDetails;
import com.food.information.service.services.GetFoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodFinder {
    private final GetFoodService getFoodService;
    private final FoodFormatter foodFormatter;

    public FoodFinder(GetFoodService getFoodService, FoodFormatter foodFormatter) {
        this.getFoodService = getFoodService;
        this.foodFormatter = foodFormatter;
    }

    public FoodNutritionalDetails findFood(String foodId) {
        Food food = getFoodService.getFood(foodId);

        return foodFormatter.formatFood(food);
    }
}
