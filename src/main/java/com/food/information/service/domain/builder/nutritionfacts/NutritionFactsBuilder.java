package com.food.information.service.domain.builder.nutritionfacts;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionFacts;
import com.food.information.service.domain.util.NutrientExtractor;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NutritionFactsBuilder {
    private final NutrientExtractor nutrientExtractor;

    public NutritionFactsBuilder(NutrientExtractor nutrientExtractor) {
        this.nutrientExtractor = nutrientExtractor;
    }

    public NutritionFacts buildNutritionFacts(Map<String, Nutrient> nutrients) {
        Nutrient calories = nutrientExtractor.extractNutrient(NutrientId.ENERGY_KCAL, nutrients);
        Nutrient fat = nutrientExtractor.extractNutrient(NutrientId.FAT, nutrients);
        Nutrient saturatedFat = nutrientExtractor.extractNutrient(NutrientId.SATURATED_FAT, nutrients);
        Nutrient transFat = nutrientExtractor.extractNutrient(NutrientId.TRANS_FAT, nutrients);
        Nutrient cholesterol = nutrientExtractor.extractNutrient(NutrientId.CHOLESTEROL, nutrients);
        Nutrient sodium = nutrientExtractor.extractNutrient(NutrientId.SODIUM, nutrients);
        Nutrient totalCarbohydrate = nutrientExtractor.extractNutrient(NutrientId.CARBOHYDRATE, nutrients);
        Nutrient dietaryFiber = nutrientExtractor.extractNutrient(NutrientId.FIBER, nutrients);
        Nutrient sugar = nutrientExtractor.extractNutrient(NutrientId.SUGARS, nutrients);
        Nutrient protein = nutrientExtractor.extractNutrient(NutrientId.PROTEIN, nutrients);

        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setCaloriesFormatted(calories.getValueFormatted());
        nutritionFacts.setCaloriesDailyValue(calories.getPercentDailyValueFormatted());
        nutritionFacts.setFatValueFormatted(fat.getValueFormatted());
        nutritionFacts.setFatPercentDailyValueFormatted(fat.getPercentDailyValueFormatted());
        nutritionFacts.setSaturatedFatValueFormatted(saturatedFat.getValueFormatted());
        nutritionFacts.setSaturatedFatPercentDailyValueFormatted(saturatedFat.getPercentDailyValueFormatted());
        nutritionFacts.setTransFatValueFormatted(transFat.getValueFormatted());
        nutritionFacts.setTransFatPercentDailyValueFormatted(transFat.getPercentDailyValueFormatted());
        nutritionFacts.setCholesterolValueFormatted(cholesterol.getValueFormatted());
        nutritionFacts.setCholesterolPercentDailyValueFormatted(cholesterol.getPercentDailyValueFormatted());
        nutritionFacts.setSodiumValueFormatted(sodium.getValueFormatted());
        nutritionFacts.setSodiumPercentDailyValueFormatted(sodium.getPercentDailyValueFormatted());
        nutritionFacts.setTotalCarbohydrateValueFormatted(totalCarbohydrate.getValueFormatted());
        nutritionFacts.setTotalCarbohydratePercentDailyValueFormatted(totalCarbohydrate.getPercentDailyValueFormatted());
        nutritionFacts.setDietaryFiberValueFormatted(dietaryFiber.getValueFormatted());
        nutritionFacts.setDietaryFiberPercentDailyValueFormatted(dietaryFiber.getPercentDailyValueFormatted());
        nutritionFacts.setSugarValueFormatted(sugar.getValueFormatted());
        nutritionFacts.setSugarPercentDailyValueFormatted(sugar.getPercentDailyValueFormatted());
        nutritionFacts.setProteinValueFormatted(protein.getValueFormatted());
        nutritionFacts.setProteinPercentDailyValueFormatted(protein.getPercentDailyValueFormatted());

        return nutritionFacts;
    }
}
