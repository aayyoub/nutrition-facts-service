package com.food.information.service.domain.util;

import com.food.information.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ServingSizeSelector {
    public ServingSize getSelectedServingSize(Set<ServingSize> servingSizes, Integer selectedServingSize) {
        if (selectedServingSize == 0) {
            return ServingSize.builder().order(0).description("100 grams").build();
        }

        return servingSizes.stream()
                           .filter(servingSize -> servingSize.getOrder().equals(selectedServingSize))
                           .findAny()
                           .orElse(ServingSize.empty());
    }
}
