package com.food.information.service.domain.builder.nutritionalstatements.analyzer;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionalStatement;
import com.food.information.service.domain.util.NutrientExtractor;
import com.food.information.service.domain.util.NutrientId;
import com.food.information.service.util.Translator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class TotalSugarAnalyzer implements NutrientAnalyzer {
    private final NutrientExtractor nutrientExtractor;
    private final Translator translator;

    public TotalSugarAnalyzer(NutrientExtractor nutrientExtractor, Translator translator) {
        this.nutrientExtractor = nutrientExtractor;
        this.translator = translator;
    }

    @Override
    public Optional<NutritionalStatement> getNutritionalStatement(Map<String, Nutrient> nutrients) {
        Nutrient nutrient = nutrientExtractor.extractNutrient(NutrientId.TOTAL_SUGAR, nutrients);

        if (nutrient.getValue() == 0.0) {
            return Optional.ofNullable(NutritionalStatement.builder()
                                                           .isBeneficial(true)
                                                           .analysisStatement(translator.getMessage("nutritional.statements.zero.sugar"))
                                                           .build());
        } else if (nutrient.getValue() >= 10.0) {
            return Optional.ofNullable(NutritionalStatement.builder()
                                                           .isBeneficial(false)
                                                           .analysisStatement(translator.getMessage("nutritional.statements.high.sugar", List.of(nutrient.getValueFormattedWithoutSpaces())))
                                                           .build());
        }

        return Optional.empty();
    }

    @Override
    public boolean matches(Map<String, Nutrient> nutrients) {
        return nutrientExtractor.containsNutrient(NutrientId.TOTAL_SUGAR, nutrients);
    }
}
