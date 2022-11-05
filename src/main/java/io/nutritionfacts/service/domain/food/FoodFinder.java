package io.nutritionfacts.service.domain.food;

import io.nutritionfacts.service.domain.food.formatter.FoodFormatter;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodAttributes;
import io.nutritionfacts.service.domain.model.FoodSummary;
import io.nutritionfacts.service.service.food.FoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodFinder {
  private final FoodService foodService;
  private final FoodFormatter foodFormatter;

  public FoodFinder(FoodService foodService, FoodFormatter foodFormatter) {
    this.foodService = foodService;
    this.foodFormatter = foodFormatter;
  }

  public Food findFood(FoodAttributes foodAttributes) {
    FoodSummary food = foodService.getFood(foodAttributes.getFoodId());

    return foodFormatter.formatFood(food, foodAttributes.getServingSize());
  }
}
