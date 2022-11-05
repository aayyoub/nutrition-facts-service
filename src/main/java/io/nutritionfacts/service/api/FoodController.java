package io.nutritionfacts.service.api;

import io.nutritionfacts.service.api.model.Response;
import io.nutritionfacts.service.domain.food.FoodFinder;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodAttributes;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
  private final FoodFinder foodFinder;

  public FoodController(FoodFinder foodFinder) {
    this.foodFinder = foodFinder;
  }

  @GetMapping(value = {"/food/{foodId}", "/food/{foodId}/{servingSize}"})
  public Response<Food> getFood(@Valid FoodAttributes foodAttributes) {
    Food food = foodFinder.findFood(foodAttributes);

    Response<Food> response = new Response<>();
    response.setHttpStatus(HttpStatus.OK);
    response.setResult(food);

    return response;
  }
}
