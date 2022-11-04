package io.nutritionfacts.service.domain;

import io.nutritionfacts.service.domain.formatter.FoodFormatter;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.services.food.IFoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodFinder {
    private final IFoodService foodService;
    private final FoodFormatter foodFormatter;

    public FoodFinder(IFoodService foodService, FoodFormatter foodFormatter) {
        this.foodService = foodService;
        this.foodFormatter = foodFormatter;
    }

    public Food findFood(String name, Integer servingSize) {
        String foodId = foodService.getFoodId(name);

        Food food = foodService.getFood(foodId);

        return foodFormatter.formatFood(food, servingSize);
    }
}
