package io.nutritionfacts.service.domain.food.formatter.component.grouper;

import io.nutritionfacts.service.domain.food.formatter.component.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Mineral implements Group {
  public String getName() {
    return "Minerals";
  }

  public Integer getRank() {
    return 5;
  }

  public List<String> getNutrients() {
    return Arrays.asList(
        NutrientId.CALCIUM,
        NutrientId.IRON,
        NutrientId.MAGNESIUM,
        NutrientId.PHOSPHORUS,
        NutrientId.POTASSIUM,
        NutrientId.SODIUM,
        NutrientId.ZINC,
        NutrientId.COPPER,
        NutrientId.MANGANESE,
        NutrientId.SELENIUM,
        NutrientId.FLUORIDE);
  }
}
