package io.nutritionfacts.service.domain.food.formatter.components;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class NutrientGroupFormatter {
    private final List<NutrientGrouper> nutrientGroupers;

    public NutrientGroupFormatter(List<NutrientGrouper> nutrientGroupers) {
        this.nutrientGroupers = nutrientGroupers;
    }

    public List<NutrientGroup> buildNutrientGroups(Map<String, Nutrient> nutrients) {
        return nutrientGroupers
                .stream()
                .map(nutrientGrouper -> nutrientGrouper.buildNutrients(nutrients))
                .sorted(Comparator.comparingInt(NutrientGroup::getRank))
                .collect(Collectors.toList());
    }
}
