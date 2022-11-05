package io.nutritionfacts.service.domain.food;

import io.nutritionfacts.service.domain.food.formatter.FoodFormatter;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodAttributes;
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

  public Food findFood(FoodAttributes foodAttributes) {
    Food food = foodService.getFood(foodAttributes.getFoodId());

    return foodFormatter.formatFood(food, foodAttributes.getServingSize());
  }
}
