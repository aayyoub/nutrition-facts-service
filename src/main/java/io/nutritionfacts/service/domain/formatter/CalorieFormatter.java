package io.nutritionfacts.service.domain.formatter;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.util.NutrientExtractor;
import io.nutritionfacts.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CalorieFormatter {
    private static final String FORMATTED_CALORIES = "%.0f calories";
    private final NutrientExtractor nutrientExtractor;

    public CalorieFormatter(NutrientExtractor nutrientExtractor) {
        this.nutrientExtractor = nutrientExtractor;
    }

    public String format(Map<String, Nutrient> nutrients) {
        Optional<Nutrient> calories = nutrientExtractor.extractNutrient(NutrientId.ENERGY_KCAL, nutrients);

        if (calories.isPresent()) {
            return String.format(FORMATTED_CALORIES, calories.get().getValue());
        }

        return String.format(FORMATTED_CALORIES, 0.0);
    }
}
