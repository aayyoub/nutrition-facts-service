package com.food.information.service.domain.builder.nutritionalstatements;

import com.food.information.service.domain.builder.nutritionalstatements.analyzer.NutrientAnalyzer;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionalStatement;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class NutritionalStatementsBuilder {
    private final List<NutrientAnalyzer> nutrientAnalyzers;

    public NutritionalStatementsBuilder(List<NutrientAnalyzer> nutrientAnalyzers) {
        this.nutrientAnalyzers = nutrientAnalyzers;
    }

    public List<NutritionalStatement> buildNutritionalStatements(Map<String, Nutrient> nutrients) {
        return nutrientAnalyzers.stream()
                                .filter(nutrientAnalyzer -> nutrientAnalyzer.matches(nutrients))
                                .map(nutrientAnalyzer -> nutrientAnalyzer.getNutritionalStatement(nutrients))
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .collect(toList());
    }
}
