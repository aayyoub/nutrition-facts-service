package io.nutritionfacts.service.domain.food.formatter.component.grouper;

import io.nutritionfacts.service.domain.model.NutrientId;
import java.util.List;

public interface Group {
  String getName();

  Integer getRank();

  List<NutrientId> getNutrients();
}
