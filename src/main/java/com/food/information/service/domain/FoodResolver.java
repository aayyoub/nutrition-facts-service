package com.food.information.service.domain;

import com.food.information.service.services.FoodResolverService;
import org.springframework.stereotype.Component;

@Component
public class FoodResolver {
    private final FoodResolverService foodResolverService;

    public FoodResolver(FoodResolverService foodResolverService) {
        this.foodResolverService = foodResolverService;
    }

    public String resolveFood(String foodId) {
        return foodResolverService.resolveFood(foodId);
    }
}
