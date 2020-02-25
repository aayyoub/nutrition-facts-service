package com.food.information.service.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
