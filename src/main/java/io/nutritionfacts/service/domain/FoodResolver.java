package io.nutritionfacts.service.domain;

import io.nutritionfacts.service.services.food.impl.FoodService;
import org.springframework.stereotype.Component;

@Component
public class FoodResolver {
    private final FoodService foodResolverService;

    public FoodResolver(FoodService foodResolverService) {
        this.foodResolverService = foodResolverService;
    }

    public String resolveFood(String foodId) {
        return foodResolverService.getFoodId(foodId);
    }
}
