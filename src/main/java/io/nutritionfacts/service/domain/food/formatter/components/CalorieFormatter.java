package io.nutritionfacts.service.domain.food.formatter.components;

import io.nutritionfacts.service.domain.model.Nutrient;
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
        Optional<Nutrient> calories = nutrientExtractor.extract(NutrientId.ENERGY_KCAL, nutrients);

        if (calories.isPresent()) {
            return String.format(FORMATTED_CALORIES, calories.get().getValue());
        }

        return String.format(FORMATTED_CALORIES, 0.0);
    }
}
