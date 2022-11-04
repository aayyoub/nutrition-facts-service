package io.nutritionfacts.service.domain.builder.nutrientgroup;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;

import java.util.Map;

public interface NutrientGrouper {
    NutrientGroup buildNutrients(Map<String, Nutrient> nutrients);
}
