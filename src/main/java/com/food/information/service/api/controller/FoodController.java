package com.food.information.service.api.controller;

import com.food.information.service.api.model.Response;
import com.food.information.service.domain.model.FoodNutritionalDetails;
import com.food.information.service.orchestration.FoodOrchestrator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    private final FoodOrchestrator foodOrchestrator;

    public FoodController(FoodOrchestrator foodOrchestrator) {
        this.foodOrchestrator = foodOrchestrator;
    }

    @CrossOrigin
    @GetMapping("/food")
    public ResponseEntity<Response> getFood(@RequestParam String foodId) {
        FoodNutritionalDetails foodNutritionalDetails = foodOrchestrator.getFood(foodId);

        Response response = new Response();
        response.setHttpStatus(HttpStatus.OK);
        response.setResult(foodNutritionalDetails);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
