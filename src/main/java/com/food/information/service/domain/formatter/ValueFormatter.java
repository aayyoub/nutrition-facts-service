package com.food.information.service.domain.formatter;

import com.food.information.service.domain.model.Nutrient;
import org.springframework.stereotype.Component;

@Component
public class ValueFormatter {
    private static final String VALUE_FORMATTED = "%.0f %s";

    public Nutrient formatValue(Nutrient nutrient) {
        String formattedValue = String.format(VALUE_FORMATTED, nutrient.getValue(), nutrient.getUnit());
        nutrient.setValueFormatted(formattedValue);

        return nutrient;
    }
}
