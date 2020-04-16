package com.food.information.service.domain.builder.nutritionalstatements;

import com.food.information.service.domain.builder.nutritionalstatements.analyzer.DailyValueAnalyzer;
import com.food.information.service.domain.builder.nutritionalstatements.analyzer.ValueAnalyzer;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionStatement;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class NutritionStatementsBuilder {
    private final ValueAnalyzer valueAnalyzer;
    private final DailyValueAnalyzer dailyValueAnalyzer;

    public NutritionStatementsBuilder(ValueAnalyzer valueAnalyzer, DailyValueAnalyzer dailyValueAnalyzer) {
        this.valueAnalyzer = valueAnalyzer;
        this.dailyValueAnalyzer = dailyValueAnalyzer;
    }

    public List<NutritionStatement> buildNutritionStatements(Map<String, Nutrient> nutrients) {
        return nutrients.values().stream()
                        .map(this::getNutritionStatement)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .sorted(Comparator.comparing(NutritionStatement::isBeneficial))
                        .collect(toList());
    }

    private Optional<NutritionStatement> getNutritionStatement(Nutrient nutrient) {
        if (Objects.nonNull(nutrient.getTargetLessThanValue()) || Objects.nonNull(nutrient.getTargetMoreThanValue())) {
            return valueAnalyzer.getNutritionStatement(nutrient);
        } else if (Objects.nonNull(nutrient.getTargetLessThanDailyValue()) || Objects.nonNull(nutrient.getTargetMoreThanDailyValue())) {
            //return dailyValueAnalyzer.getNutritionStatement(nutrient);
        }

        return Optional.empty();
    }
}
