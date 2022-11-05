package io.nutritionfacts.service.api;

import io.nutritionfacts.service.api.model.request.FoodRequest;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.orchestration.FoodOrchestrator;
import io.nutritionfacts.service.api.model.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FoodController {
  private final FoodOrchestrator foodOrchestrator;

  public FoodController(FoodOrchestrator foodOrchestrator) {
    this.foodOrchestrator = foodOrchestrator;
  }

  @GetMapping(value = {"/food/{foodName}", "/food/{foodName}/{servingSize}"})
  public Response<Food> getFood(@Valid FoodRequest foodRequest) {
    Food food = foodOrchestrator.getFood(foodRequest);

    Response<Food> response = new Response<>();
    response.setHttpStatus(HttpStatus.OK);
    response.setResult(food);

    return response;
  }
}
