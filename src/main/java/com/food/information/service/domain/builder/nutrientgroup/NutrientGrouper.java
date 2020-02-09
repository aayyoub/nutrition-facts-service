package com.food.information.service.domain.builder.nutrientgroup;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutrientGroup;

import java.util.Map;

public interface NutrientGrouper {
    NutrientGroup buildNutrients(Map<String, Nutrient> nutrients);
}
