package io.nutritionfacts.api.api.controller;

import io.nutritionfacts.api.api.model.GetFoodRequest;
import io.nutritionfacts.api.api.model.Response;
import io.nutritionfacts.api.api.filter.RequestContext;
import io.nutritionfacts.api.domain.model.Food;
import io.nutritionfacts.api.orchestration.FoodOrchestrator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class FoodController {
    private final FoodOrchestrator foodOrchestrator;
    private final RequestContext requestContext;

    public FoodController(FoodOrchestrator foodOrchestrator, RequestContext requestContext) {
        this.foodOrchestrator = foodOrchestrator;
        this.requestContext = requestContext;
    }

    @CrossOrigin
    @GetMapping(value = {"/food/{foodName}", "/food/{foodName}/{servingSize}"})
    public Response<Food> getFood(@Valid GetFoodRequest getFoodRequest) {
        Food food = foodOrchestrator.getFood(getFoodRequest);

        Response<Food> response = new Response<>();
        response.setHttpStatus(HttpStatus.OK);
        response.setRequestId(requestContext.getRequestId());
        response.setResult(food);

        return response;
    }
}
