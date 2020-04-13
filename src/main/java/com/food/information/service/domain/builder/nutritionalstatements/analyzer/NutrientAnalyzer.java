package com.food.information.service.domain.builder.nutritionalstatements.analyzer;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionalStatement;

import java.util.Map;
import java.util.Optional;

public interface NutrientAnalyzer {
    Optional<NutritionalStatement> getNutritionalStatement(Map<String, Nutrient> nutrients);

    boolean matches(Map<String, Nutrient> nutrients);
}
