package io.nutritionfacts.service.domain.model;

import java.util.Map;
import java.util.Optional;
import lombok.Data;

@Data
public class Nutrients {
  public Map<NutrientId, Nutrient> nutrients;

  public Nutrients(Map<NutrientId, Nutrient> nutrients) {
    this.nutrients = nutrients;
  }

  public Optional<Nutrient> get(NutrientId nutrientId) {
    if (isEmpty()) {
      return Optional.empty();
    }

    return nutrients
        .values()
        .stream()
        .filter(nutrient -> nutrient.getId() == nutrientId)
        .findAny();
  }

  private boolean isEmpty() {
    return nutrients == null || nutrients.size() == 0;
  }
}
