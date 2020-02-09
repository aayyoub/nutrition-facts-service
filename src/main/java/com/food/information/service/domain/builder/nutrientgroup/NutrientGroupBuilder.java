package com.food.information.service.domain.builder.nutrientgroup;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutrientGroup;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class NutrientGroupBuilder {
    private final List<NutrientGrouper> nutrientGroupers;

    public NutrientGroupBuilder(List<NutrientGrouper> nutrientGroupers) {
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
