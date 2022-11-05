package io.nutritionfacts.service.domain.food.formatter.component.grouper.nutrient;

import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.Group;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Other implements Group {
  public String getName() {
    return "Other";
  }

  public Integer getRank() {
    return 7;
  }

  public List<NutrientId> getNutrients() {
    return Arrays.asList(
        NutrientId.WATER,
        NutrientId.ASH,
        NutrientId.ALCOHOL,
        NutrientId.CAFFEINE,
        NutrientId.THEOBROMINE);
  }
}
