package io.nutritionfacts.service.api.controller;

import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.orchestration.FoodOrchestrator;
import io.nutritionfacts.service.api.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class FoodController {
    private final FoodOrchestrator foodOrchestrator;

    public FoodController(FoodOrchestrator foodOrchestrator) {
        this.foodOrchestrator = foodOrchestrator;
    }

    @CrossOrigin
    @GetMapping(value = {"/food/{foodName}", "/food/{foodName}/{servingSize}"})
    public Response<Food> getFood(@Valid GetFoodRequest getFoodRequest) {
        Food food = foodOrchestrator.getFood(getFoodRequest);

        Response<Food> response = new Response<>();
        response.setHttpStatus(HttpStatus.OK);
        response.setResult(food);

        return response;
    }
}
