package com.food.information.service.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class CaloricPyramid {
    private Double alcoholPercentage;
    private Double carbohydratePercentage;
    private Double fatPercentage;
    private Double proteinPercentage;
    private String alcoholPercentageFormatted;
    private String carbohydratePercentageFormatted;
    private String fatPercentageFormatted;
    private String proteinPercentageFormatted;
    private Double caloriesFromAlcohol;
    private Double caloriesFromCarbohydrates;
    private Double caloriesFromFat;
    private Double caloriesFromProtein;
}
