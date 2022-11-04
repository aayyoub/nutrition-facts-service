package io.nutritionfacts.service.domain;

import io.nutritionfacts.service.domain.formatter.FoodFormatter;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;
import io.nutritionfacts.service.service.food.IFoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodFinder {
    private final IFoodService foodService;
    private final FoodFormatter foodFormatter;

    public FoodFinder(IFoodService foodService, FoodFormatter foodFormatter) {
        this.foodService = foodService;
        this.foodFormatter = foodFormatter;
    }

    public Food findFood(String foodName, Integer servingSize) {
        FoodId foodId = foodService.getFoodId(foodName);

        Food food = foodService.getFood(foodId);

        return foodFormatter.formatFood(food, servingSize);
    }
}
