package io.nutritionfacts.service.domain.food.formatter.component;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.model.Nutrients;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CalorieFormatter {
  private static final String FORMATTED_CALORIES = "%.0f calories";

  public String format(Nutrients nutrients) {
    Optional<Nutrient> nutrient = nutrients.get(NutrientId.ENERGY_KCAL);

    if (nutrient.isPresent()) {
      return String.format(FORMATTED_CALORIES, nutrient.get().getValue());
    }

    return String.format(FORMATTED_CALORIES, 0.0);
  }
}
