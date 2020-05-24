package io.nutritionfacts.api.domain.builder.nutritionfacts;

import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.model.NutritionFacts;
import io.nutritionfacts.api.domain.model.ServingSize;
import io.nutritionfacts.api.domain.util.NutrientExtractor;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NutritionFactsBuilder {
    private final NutrientExtractor nutrientExtractor;

    public NutritionFactsBuilder(NutrientExtractor nutrientExtractor) {
        this.nutrientExtractor = nutrientExtractor;
    }

    public NutritionFacts buildNutritionFacts(Map<String, Nutrient> nutrients, ServingSize selectedServingSize) {
        Nutrient calories = nutrientExtractor.extractNutrient(NutrientId.ENERGY_KCAL, nutrients);
        Nutrient fat = nutrientExtractor.extractNutrient(NutrientId.TOTAL_FAT, nutrients);
        Nutrient saturatedFat = nutrientExtractor.extractNutrient(NutrientId.FATTY_ACIDS_TOTAL_SATURATED, nutrients);
        Nutrient transFat = nutrientExtractor.extractNutrient(NutrientId.FATTY_ACIDS_TOTAL_TRANS, nutrients);
        Nutrient cholesterol = nutrientExtractor.extractNutrient(NutrientId.CHOLESTEROL, nutrients);
        Nutrient sodium = nutrientExtractor.extractNutrient(NutrientId.SODIUM, nutrients);
        Nutrient totalCarbohydrate = nutrientExtractor.extractNutrient(NutrientId.CARBOHYDRATE, nutrients);
        Nutrient dietaryFiber = nutrientExtractor.extractNutrient(NutrientId.FIBER, nutrients);
        Nutrient sugar = nutrientExtractor.extractNutrient(NutrientId.TOTAL_SUGAR, nutrients);
        Nutrient protein = nutrientExtractor.extractNutrient(NutrientId.TOTAL_PROTEIN, nutrients);

        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setSelectedServingSize(selectedServingSize.getDescription());
        nutritionFacts.setCalories(calories.getValueRounded());
        nutritionFacts.setTotalFat(fat.getValueGaussianRoundedWithUnit());
        nutritionFacts.setTotalFatPercentDailyValue(fat.getPercentDailyValueFormatted());
        nutritionFacts.setSaturatedFat(saturatedFat.getValueGaussianRoundedWithUnit());
        nutritionFacts.setSaturatedFatPercentDailyValue(saturatedFat.getPercentDailyValueFormatted());
        nutritionFacts.setTransFat(transFat.getValueGaussianRoundedWithUnit());
        nutritionFacts.setCholesterol(cholesterol.getValueGaussianRoundedWithUnit());
        nutritionFacts.setCholesterolPercentDailyValue(cholesterol.getPercentDailyValueFormatted());
        nutritionFacts.setSodium(sodium.getValueGaussianRoundedWithUnit());
        nutritionFacts.setSodiumPercentDailyValue(sodium.getPercentDailyValueFormatted());
        nutritionFacts.setTotalCarbohydrate(totalCarbohydrate.getValueGaussianRoundedWithUnit());
        nutritionFacts.setTotalCarbohydratePercentDailyValue(totalCarbohydrate.getPercentDailyValueFormatted());
        nutritionFacts.setDietaryFiber(dietaryFiber.getValueGaussianRoundedWithUnit());
        nutritionFacts.setDietaryFiberPercentDailyValue(dietaryFiber.getPercentDailyValueFormatted());
        nutritionFacts.setSugar(sugar.getValueGaussianRoundedWithUnit());
        nutritionFacts.setProtein(protein.getValueGaussianRoundedWithUnit());

        return nutritionFacts;
    }
}
