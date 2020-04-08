package com.food.information.service.api.controller;

import com.food.information.service.api.model.GetFoodRequest;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.FoodNutritionalDetails;
import com.food.information.service.orchestration.FoodOrchestrator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FoodController {
    private final FoodOrchestrator foodOrchestrator;

    public FoodController(FoodOrchestrator foodOrchestrator) {
        this.foodOrchestrator = foodOrchestrator;
    }

    @CrossOrigin
    @GetMapping("/food")
    @Cacheable(value = "food", key = "{#getFoodRequest.foodId,#getFoodRequest.servingSize}")
    public Food getFood(GetFoodRequest getFoodRequest) {
        return foodOrchestrator.getFood(getFoodRequest);
    }
}
