package com.food.information.service.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class FoodNutritionalDetails {
    private String longDescription;
    private String shortDescription;
    private String formattedDescription;
    private String formattedCalories;
    private NutritionFacts nutritionFacts;
    private CaloricPyramid caloricPyramid;
    private List<NutrientGroup> nutrientGroups;
    private Set<ServingSize> servingSizes;
}
