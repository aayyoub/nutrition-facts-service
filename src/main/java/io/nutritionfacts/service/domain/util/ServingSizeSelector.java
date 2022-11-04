package io.nutritionfacts.service.domain.util;

import io.nutritionfacts.service.domain.model.ServingSize;
import io.nutritionfacts.service.exception.InvalidServingSizeException;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ServingSizeSelector {
    public ServingSize getSelectedServingSize(Set<ServingSize> servingSizes, Integer selectedServingSize) {
        return servingSizes.stream()
                           .filter(servingSize -> servingSize.getOrder().equals(selectedServingSize))
                           .findAny()
                           .orElseThrow(() -> new InvalidServingSizeException("Invalid serving size: " + selectedServingSize));
    }
}
