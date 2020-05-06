package io.nutritionfacts.api.domain.formatter;

import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.util.NutrientExtractor;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CalorieFormatter {
    private static final String FORMATTED_CALORIES = "%.0f calories";
    private final NutrientExtractor nutrientExtractor;

    public CalorieFormatter(NutrientExtractor nutrientExtractor) {
        this.nutrientExtractor = nutrientExtractor;
    }

    public String format(Map<String, Nutrient> nutrients) {
        Double calories = nutrientExtractor.extractNutrient(NutrientId.ENERGY_KCAL, nutrients).getValue();

        return String.format(FORMATTED_CALORIES, calories);
    }
}
