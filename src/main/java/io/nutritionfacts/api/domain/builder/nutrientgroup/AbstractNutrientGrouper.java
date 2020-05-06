package io.nutritionfacts.api.domain.builder.nutrientgroup;

import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.model.NutrientGroup;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractNutrientGrouper implements NutrientGrouper {
    protected abstract List<String> getRequiredNutrients();

    protected abstract Integer getRank();

    protected abstract String getGroupName();

    public NutrientGroup buildNutrients(Map<String, Nutrient> nutrients) {
        List<Nutrient> filteredNutrients = nutrients.values()
                                                    .stream()
                                                    .filter(nutrient -> this.getRequiredNutrients().contains(nutrient.getId()))
                                                    .sorted(Comparator.comparingInt(Nutrient::getSortOrder))
                                                    .collect(Collectors.toList());

        return new NutrientGroup(this.getRank(), this.getGroupName(), filteredNutrients);
    }
}
