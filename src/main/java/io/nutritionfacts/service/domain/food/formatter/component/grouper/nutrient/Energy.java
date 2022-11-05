package io.nutritionfacts.service.domain.food.formatter.component.grouper.nutrient;

import io.nutritionfacts.service.domain.food.formatter.component.NutrientId;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.Group;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Energy implements Group {
  public String getName() {
    return "Energy";
  }

  public Integer getRank() {
    return 0;
  }

  @Override
  public List<String> getNutrients() {
    return Arrays.asList(
        NutrientId.ENERGY_KCAL,
        NutrientId.ENERGY_KJ
    );
  }
}
