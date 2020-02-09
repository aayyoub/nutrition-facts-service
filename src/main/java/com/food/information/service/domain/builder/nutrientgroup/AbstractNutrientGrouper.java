package com.food.information.service.domain.builder.nutrientgroup;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutrientGroup;

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
                .filter(nutrient -> this.getRequiredNutrients().contains(nutrient.getTagname()))
                .sorted(Comparator.comparingInt(Nutrient::getSortOrder))
                .collect(Collectors.toList());

        return new NutrientGroup(this.getRank(), this.getGroupName(), filteredNutrients);
    }
}
