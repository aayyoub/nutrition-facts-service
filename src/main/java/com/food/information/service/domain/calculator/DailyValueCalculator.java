package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.Nutrient;
import org.springframework.stereotype.Component;

@Component
public class DailyValueCalculator {
    private static final String PERCENT_DAILY_VALUE_FORMATTED = "%.0f%%";

    public Nutrient calculateDailyValue(Nutrient nutrient) {
        if (nutrient.getValue() != null && nutrient.getDailyValue() != null) {
            Double percentDailyValue = (nutrient.getValue() / nutrient.getDailyValue()) * 100;

            nutrient.setPercentDailyValue(percentDailyValue);
            nutrient.setPercentDailyValueFormatted(String.format(PERCENT_DAILY_VALUE_FORMATTED, percentDailyValue));
        } else {
            nutrient.setPercentDailyValue(0.0);
            nutrient.setPercentDailyValueFormatted("");
        }

        return nutrient;
    }
}
