package io.nutritionfacts.api.domain.builder.nutrientgroup;

import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.model.NutrientGroup;

import java.util.Map;

public interface NutrientGrouper {
    NutrientGroup buildNutrients(Map<String, Nutrient> nutrients);
}
