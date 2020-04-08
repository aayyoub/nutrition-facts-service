package com.food.information.service.domain;

import com.food.information.service.domain.formatter.FoodFormatter;
import com.food.information.service.domain.model.Food;
import com.food.information.service.services.FoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodFinder {
    private final FoodService foodService;
    private final FoodFormatter foodFormatter;

    public FoodFinder(FoodService foodService, FoodFormatter foodFormatter) {
        this.foodService = foodService;
        this.foodFormatter = foodFormatter;
    }

    public Food findFood(String foodId, Integer servingSize) {
        Food food = foodService.getFood(foodId);

        return foodFormatter.formatFood(food, servingSize);
    }
}
