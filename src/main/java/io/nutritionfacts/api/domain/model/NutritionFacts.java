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
public class NutritionFacts {
    String calories;
    String selectedServingSize;
    String totalFat;
    String totalFatPercentDailyValue;
    String saturatedFat;
    String saturatedFatPercentDailyValue;
    String transFat;
    String cholesterol;
    String cholesterolPercentDailyValue;
    String sodium;
    String sodiumPercentDailyValue;
    String totalCarbohydrate;
    String totalCarbohydratePercentDailyValue;
    String dietaryFiber;
    String dietaryFiberPercentDailyValue;
    String sugar;
    String protein;
}
