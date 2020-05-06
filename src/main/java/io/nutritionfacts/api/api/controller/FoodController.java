package io.nutritionfacts.api.api.controller;

import io.nutritionfacts.api.api.model.GetFoodRequest;
import io.nutritionfacts.api.domain.model.Food;
import io.nutritionfacts.api.orchestration.FoodOrchestrator;
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
    @GetMapping("/food/{foodName}")
    @Cacheable(value = "food", key = "{#getFoodRequest.foodName,#getFoodRequest.servingSize}")
    public Food getFood(GetFoodRequest getFoodRequest) {
        return foodOrchestrator.getFood(getFoodRequest);
    }

    @CrossOrigin
    @GetMapping("/food/{foodName}/{servingSize}")
    @Cacheable(value = "food", key = "{#getFoodRequest.foodName,#getFoodRequest.servingSize}")
    public Food getFoodForServingSize(GetFoodRequest getFoodRequest) {
        return foodOrchestrator.getFood(getFoodRequest);
    }
}
