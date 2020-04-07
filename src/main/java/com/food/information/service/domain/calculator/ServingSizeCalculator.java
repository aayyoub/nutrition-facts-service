package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

@Component
public class ServingSizeCalculator {
    public Double calculateValue(Nutrient nutrient, ServingSize servingSize) {
        if (servingSize.getOrder() > 0) {
            return nutrient.getValue() * servingSize.getGramWeight() / 100;
        }

        return nutrient.getValue();
    }
}
