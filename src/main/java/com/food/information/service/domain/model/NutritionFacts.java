package com.food.information.service.domain.model;

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
public class NutritionFacts {
    String caloriesValueFormatted;
    String caloriesFromFatFormatted;
    String fatValueFormatted;
    String fatPercentDailyValueFormatted;
    String saturatedFatValueFormatted;
    String saturatedFatPercentDailyValueFormatted;
    String transFatValueFormatted;
    String cholesterolValueFormatted;
    String cholesterolPercentDailyValueFormatted;
    String sodiumValueFormatted;
    String sodiumPercentDailyValueFormatted;
    String totalCarbohydrateValueFormatted;
    String totalCarbohydratePercentDailyValueFormatted;
    String dietaryFiberValueFormatted;
    String dietaryFiberPercentDailyValueFormatted;
    String sugarValueFormatted;
    String proteinValueFormatted;
}
