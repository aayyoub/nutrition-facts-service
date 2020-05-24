package io.nutritionfacts.api.domain.builder.nutritionfacts;

import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.model.NutritionFacts;
import io.nutritionfacts.api.domain.model.ServingSize;
import io.nutritionfacts.api.domain.util.NutrientExtractor;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class NutritionFactsBuilder {
    private static final String ZERO = "0";
    private static final String ZERO_MG = "0mg";
    private static final String ZERO_G = "0g";
    private static final String ZERO_PERCENT = "0%";
    private final NutrientExtractor nutrientExtractor;

    public NutritionFactsBuilder(NutrientExtractor nutrientExtractor) {
        this.nutrientExtractor = nutrientExtractor;
    }

    public NutritionFacts buildNutritionFacts(Map<String, Nutrient> nutrients, ServingSize selectedServingSize) {
        Optional<Nutrient> calories = nutrientExtractor.extractNutrient(NutrientId.ENERGY_KCAL, nutrients);
        Optional<Nutrient> fat = nutrientExtractor.extractNutrient(NutrientId.TOTAL_FAT, nutrients);
        Optional<Nutrient> saturatedFat = nutrientExtractor.extractNutrient(NutrientId.FATTY_ACIDS_TOTAL_SATURATED, nutrients);
        Optional<Nutrient> transFat = nutrientExtractor.extractNutrient(NutrientId.FATTY_ACIDS_TOTAL_TRANS, nutrients);
        Optional<Nutrient> cholesterol = nutrientExtractor.extractNutrient(NutrientId.CHOLESTEROL, nutrients);
        Optional<Nutrient> sodium = nutrientExtractor.extractNutrient(NutrientId.SODIUM, nutrients);
        Optional<Nutrient> totalCarbohydrate = nutrientExtractor.extractNutrient(NutrientId.CARBOHYDRATE, nutrients);
        Optional<Nutrient> dietaryFiber = nutrientExtractor.extractNutrient(NutrientId.FIBER, nutrients);
        Optional<Nutrient> sugar = nutrientExtractor.extractNutrient(NutrientId.TOTAL_SUGAR, nutrients);
        Optional<Nutrient> protein = nutrientExtractor.extractNutrient(NutrientId.TOTAL_PROTEIN, nutrients);

        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setSelectedServingSize(selectedServingSize.getDescription());
        nutritionFacts.setCalories(calories.isPresent() ? calories.get().getValueGaussianRoundedWithUnit() : ZERO);
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
