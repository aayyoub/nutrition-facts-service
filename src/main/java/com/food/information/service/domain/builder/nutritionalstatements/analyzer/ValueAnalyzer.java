package com.food.information.service.domain.builder.nutritionalstatements.analyzer;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionStatement;
import com.food.information.service.util.Translator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ValueAnalyzer implements Analyzer {
    private final Translator translator;

    public ValueAnalyzer(Translator translator) {
        this.translator = translator;
    }

    @Override
    public Optional<NutritionStatement> getNutritionStatement(Nutrient nutrient) {
        if (Objects.nonNull(nutrient.getTargetLessThanValue()) && nutrient.getValue() < nutrient.getTargetLessThanValue()) {
            String statement = translator.getMessage("nutritional.statements.low.value", List.of(nutrient.getCommonName().toLowerCase(), nutrient.getValueFormattedWithoutSpaces()));

            return Optional.ofNullable(NutritionStatement.builder().isBeneficial(!nutrient.getIsBeneficial()).statement(statement).build());
        } else if (Objects.nonNull(nutrient.getTargetMoreThanValue()) && nutrient.getValue() > nutrient.getTargetMoreThanValue()) {
            String statement = translator.getMessage("nutritional.statements.high.value", List.of(nutrient.getCommonName().toLowerCase(), nutrient.getValueFormattedWithoutSpaces()));

            return Optional.ofNullable(NutritionStatement.builder().isBeneficial(nutrient.getIsBeneficial()).statement(statement).build());
        }

        return Optional.empty();
    }
}
