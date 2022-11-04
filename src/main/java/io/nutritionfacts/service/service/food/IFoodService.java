package io.nutritionfacts.service.service.food;

import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;

public interface IFoodService {
    FoodId getFoodId(String foodName);

    Food getFood(FoodId foodId);
}
