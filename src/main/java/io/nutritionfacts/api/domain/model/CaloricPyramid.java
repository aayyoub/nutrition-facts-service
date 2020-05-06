package io.nutritionfacts.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
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
