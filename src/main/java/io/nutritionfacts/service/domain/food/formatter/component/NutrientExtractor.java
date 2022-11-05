package io.nutritionfacts.service.domain.food.formatter.component;

import io.nutritionfacts.service.domain.model.Nutrient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class NutrientExtractor {
    private static final String NUTRIENT_ID_REGEX = "^[0-9]{3}$";

    public Optional<Nutrient> extract(String nutrientId, Map<String, Nutrient> nutrients) {
        if (validateNutrientId(nutrientId) && validateNutrients(nutrients)) {
            return Optional.ofNullable(nutrients.get(nutrientId));
        }

        return Optional.empty();
    }

    private boolean validateNutrientId(String nutrientId) {
        return nutrientId != null && nutrientId.matches(NUTRIENT_ID_REGEX);
    }

    private boolean validateNutrients(Map<String, Nutrient> nutrients) {
        return nutrients != null && nutrients.size() > 0;
    }
}
