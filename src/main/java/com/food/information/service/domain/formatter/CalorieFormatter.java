package com.food.information.service.domain.formatter;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CalorieFormatter {
    private static final String FORMATTED_CALORIES = "%.0f calories";

    public String format(Map<String, Nutrient> nutrients) {
        Double calories = nutrients.get(NutrientId.ENERGY_KCAL).getValue();

        return String.format(FORMATTED_CALORIES, calories);
    }
}
