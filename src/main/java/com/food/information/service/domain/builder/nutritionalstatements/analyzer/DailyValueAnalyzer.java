package com.food.information.service.domain.builder.nutritionalstatements.analyzer;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionStatement;
import com.food.information.service.util.Translator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DailyValueAnalyzer implements Analyzer {
    private final Translator translator;

    public DailyValueAnalyzer(Translator translator) {
        this.translator = translator;
    }

    @Override
    public Optional<NutritionStatement> getNutritionStatement(Nutrient nutrient) {
        if (nutrient.getTargetLessThanDailyValue().isPresent() && nutrient.getDailyValue() < nutrient.getTargetLessThanDailyValue().get()) {
            String statement = translator.getMessage("nutritional.statements.percent.daily.value", List.of(nutrient.getPercentDailyValueFormatted(), nutrient.getCommonName()));

            return Optional.ofNullable(NutritionStatement.builder().isBeneficial(!nutrient.getIsBeneficial()).statement(statement).build());
        } else if (nutrient.getTargetMoreThanDailyValue().isPresent() && nutrient.getDailyValue() > nutrient.getTargetMoreThanDailyValue().get()) {
            String statement = translator.getMessage("nutritional.statements.percent.daily.value", List.of(nutrient.getPercentDailyValueFormatted(), nutrient.getCommonName()));

            return Optional.ofNullable(NutritionStatement.builder().isBeneficial(nutrient.getIsBeneficial()).statement(statement).build());
        }

        return Optional.empty();
    }
}
