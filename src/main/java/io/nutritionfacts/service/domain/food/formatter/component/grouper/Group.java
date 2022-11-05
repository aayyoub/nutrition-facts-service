package io.nutritionfacts.service.domain.food.formatter.component.grouper;

import java.util.List;

public interface Group {
  String getName();

  Integer getRank();

  List<String> getNutrients();
}
