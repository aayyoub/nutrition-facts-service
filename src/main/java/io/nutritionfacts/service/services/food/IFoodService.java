package io.nutritionfacts.service.services.food;

import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;

public interface IFoodService {
    Food getFood(String foodId);

    FoodId getFoodId(String foodName);
}
