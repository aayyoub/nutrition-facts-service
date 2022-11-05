package io.nutritionfacts.service.domain.food.formatter.component.grouper.nutrient;

import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.Group;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Carbohydrate implements Group {
  public String getName() {
    return "Carbohydrates";
  }

  public Integer getRank() {
    return 2;
  }

  public List<NutrientId> getNutrients() {
    return Arrays.asList(
        NutrientId.CARBOHYDRATE,
        NutrientId.FIBER,
        NutrientId.STARCH,
        NutrientId.TOTAL_SUGAR,
        NutrientId.SUCROSE,
        NutrientId.GLUCOSE,
        NutrientId.FRUCTOSE,
        NutrientId.LACTOSE,
        NutrientId.MALTOSE,
        NutrientId.GALACTOSE
    );
  }
}
