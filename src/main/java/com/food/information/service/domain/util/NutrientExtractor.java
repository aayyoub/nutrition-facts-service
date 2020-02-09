package com.food.information.service.domain.util;

import com.food.information.service.domain.model.Nutrient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NutrientExtractor {
    private static final String NUTRIENT_ID_REGEX = "^[0-9]{3}$";

    public Nutrient extractNutrient(String nutrientId, Map<String, Nutrient> nutrients) {
        if (validateNutrientId(nutrientId) && validateNutrients(nutrients)) {
            return nutrients.getOrDefault(nutrientId, Nutrient.empty());
        } else {
            return Nutrient.empty();
        }
    }

    private boolean validateNutrientId(String nutrientId) {
        return nutrientId != null && nutrientId.matches(NUTRIENT_ID_REGEX);
    }

    private boolean validateNutrients(Map<String, Nutrient> nutrients) {
        return nutrients != null && nutrients.size() > 0;
    }
}
