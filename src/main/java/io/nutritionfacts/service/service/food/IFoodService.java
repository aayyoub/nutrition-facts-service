package io.nutritionfacts.service.service.food;

import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;

public interface IFoodService {
    Food getFood(FoodId foodId);
}
