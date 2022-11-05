package io.nutritionfacts.service.domain.food.formatter.component;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

@Component
public class ServingSizeCalculator {
    public Double calculateValue(Nutrient nutrient, ServingSize servingSize) {
        if (servingSize.getOrder() != null && servingSize.getOrder() > 0) {
            return nutrient.getValue() * servingSize.getGramWeight() / 100;
        }

        return nutrient.getValue();
    }
}
