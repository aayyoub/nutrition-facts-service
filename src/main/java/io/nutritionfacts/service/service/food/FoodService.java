package io.nutritionfacts.service.service.food;

import io.nutritionfacts.service.domain.model.FoodId;
import io.nutritionfacts.service.domain.model.FoodSummary;

public interface FoodService {
    FoodSummary getFood(FoodId foodId);
}
