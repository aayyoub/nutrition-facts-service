package io.nutritionfacts.service.domain.food.formatter.component;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.model.Nutrients;
import io.nutritionfacts.service.domain.model.NutritionFacts;
import io.nutritionfacts.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NutritionFactsBuilder {
    private static final String ZERO = "0";
    private static final String ZERO_MG = "0mg";
    private static final String ZERO_G = "0g";
    private static final String ZERO_PERCENT = "0%";

    public NutritionFacts build(Nutrients nutrients, ServingSize servingSize) {
        Optional<Nutrient> calories = nutrients.get(NutrientId.ENERGY_KCAL);
        Optional<Nutrient> fat = nutrients.get(NutrientId.TOTAL_FAT);
        Optional<Nutrient> saturatedFat = nutrients.get(NutrientId.FATTY_ACIDS_TOTAL_SATURATED);
        Optional<Nutrient> transFat = nutrients.get(NutrientId.FATTY_ACIDS_TOTAL_TRANS);
        Optional<Nutrient> cholesterol = nutrients.get(NutrientId.CHOLESTEROL);
        Optional<Nutrient> sodium = nutrients.get(NutrientId.SODIUM);
        Optional<Nutrient> totalCarbohydrate = nutrients.get(NutrientId.CARBOHYDRATE);
        Optional<Nutrient> dietaryFiber = nutrients.get(NutrientId.FIBER);
        Optional<Nutrient> sugar = nutrients.get(NutrientId.TOTAL_SUGAR);
        Optional<Nutrient> protein = nutrients.get(NutrientId.TOTAL_PROTEIN);

        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setSelectedServingSize(servingSize.getDescription());
        nutritionFacts.setCalories(calories.isPresent() ? calories.get().getValueRounded() : ZERO);
        nutritionFacts.setTotalFat(fat.isPresent() ? fat.get().getValueGaussianRoundedWithUnit() : ZERO_G);
        nutritionFacts.setTotalFatPercentDailyValue(fat.isPresent() ? fat.get().getPercentDailyValueFormatted() : ZERO_PERCENT);
        nutritionFacts.setSaturatedFat(saturatedFat.isPresent() ? saturatedFat.get().getValueGaussianRoundedWithUnit() : ZERO_G);
        nutritionFacts.setSaturatedFatPercentDailyValue(saturatedFat.isPresent() ? saturatedFat.get().getPercentDailyValueFormatted() : ZERO_PERCENT);
        nutritionFacts.setTransFat(transFat.isPresent() ? transFat.get().getValueGaussianRoundedWithUnit() : ZERO_G);
        nutritionFacts.setCholesterol(cholesterol.isPresent() ? cholesterol.get().getValueGaussianRoundedWithUnit() : ZERO_MG);
        nutritionFacts.setCholesterolPercentDailyValue(cholesterol.isPresent() ? cholesterol.get().getPercentDailyValueFormatted() : ZERO_PERCENT);
        nutritionFacts.setSodium(sodium.isPresent() ? sodium.get().getValueGaussianRoundedWithUnit() : ZERO_MG);
        nutritionFacts.setSodiumPercentDailyValue(sodium.isPresent() ? sodium.get().getPercentDailyValueFormatted() : ZERO_PERCENT);
        nutritionFacts.setTotalCarbohydrate(totalCarbohydrate.isPresent() ? totalCarbohydrate.get().getValueGaussianRoundedWithUnit() : ZERO_G);
        nutritionFacts.setTotalCarbohydratePercentDailyValue(totalCarbohydrate.isPresent() ? totalCarbohydrate.get().getPercentDailyValueFormatted() : ZERO_PERCENT);
        nutritionFacts.setDietaryFiber(dietaryFiber.isPresent() ? dietaryFiber.get().getValueGaussianRoundedWithUnit() : ZERO_G);
        nutritionFacts.setDietaryFiberPercentDailyValue(dietaryFiber.isPresent() ? dietaryFiber.get().getPercentDailyValueFormatted() : ZERO_PERCENT);
        nutritionFacts.setSugar(sugar.isPresent() ? sugar.get().getValueGaussianRoundedWithUnit() : ZERO_G);
        nutritionFacts.setProtein(protein.isPresent() ? protein.get().getValueGaussianRoundedWithUnit() : ZERO_G);

        return nutritionFacts;
    }
}
