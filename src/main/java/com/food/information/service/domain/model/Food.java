package com.food.information.service.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private String id;
    private String name;
    private String description;
    private String calories;
    private List<NutritionalStatement> nutritionalStatements;
    private NutritionFacts nutritionFacts;
    private CaloricPyramid caloricPyramid;
    private List<NutrientGroup> nutrientGroups;
    private Set<ServingSize> servingSizes;
    @JsonIgnore
    private Map<String, Nutrient> nutrients;
    @JsonIgnore
    private Map<String, Nutrient> nutrientsPerServingSize;
}