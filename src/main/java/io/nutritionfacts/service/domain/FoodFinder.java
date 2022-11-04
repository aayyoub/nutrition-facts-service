package io.nutritionfacts.service.domain;

import io.nutritionfacts.service.domain.formatter.FoodFormatter;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.services.FoodService;
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
