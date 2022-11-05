package io.nutritionfacts.service.domain.food.formatter.component.grouper.nutrient;

import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.Group;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Sterol implements Group {
  public String getName() {
    return "Sterols";
  }

  public Integer getRank() {
    return 6;
  }

  public List<NutrientId> getNutrients() {
    return Arrays.asList(
        NutrientId.CHOLESTEROL,
        NutrientId.PHYTOSTEROLS,
        NutrientId.STIGMASTEROL,
        NutrientId.CAMPESTEROL,
        NutrientId.BETASITOSTEROL
    );
  }
}
