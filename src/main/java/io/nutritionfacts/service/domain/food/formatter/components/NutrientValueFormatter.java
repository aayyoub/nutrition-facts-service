package io.nutritionfacts.service.domain.food.formatter.components;

import org.springframework.stereotype.Component;

@Component
public class NutrientValueFormatter {
    private static final String VALUE_FORMATTED = "%s %s";
    private static final String VALUE_FORMATTED_WITHOUT_SPACE = "%s%s";

    public String formatValueRoundedWithUnit(String valueRounded, String unit) {
        if (valueRounded != null && unit != null) {
            return String.format(VALUE_FORMATTED, valueRounded, unit);
        }

        return "";
    }

    //TODO visit this display rounding
    public String formatValueGaussianRoundedWithUnit(Double value, String unit) {
        if (value != null && unit != null) {
            Integer valueRounded = (int) Math.round(value);

            return String.format(VALUE_FORMATTED_WITHOUT_SPACE, valueRounded, unit);
        }

        return "";
    }
}
