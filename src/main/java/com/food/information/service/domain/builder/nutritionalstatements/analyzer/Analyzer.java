package com.food.information.service.domain.builder.nutritionalstatements.analyzer;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionStatement;

import java.util.Optional;

public interface Analyzer {
    Optional<NutritionStatement> getNutritionStatement(Nutrient nutrient);
}
