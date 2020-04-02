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
        Nutrient fat = nutrientExtractor.extractNutrient(NutrientId.TOTAL_FAT, nutrients);
        Nutrient saturatedFat = nutrientExtractor.extractNutrient(NutrientId.TOTAL_SATURATED_FATTY_ACIDS, nutrients);
        Nutrient transFat = nutrientExtractor.extractNutrient(NutrientId.TOTAL_TRANS_FATTY_ACIDS, nutrients);
        Nutrient cholesterol = nutrientExtractor.extractNutrient(NutrientId.CHOLESTEROL, nutrients);
        Nutrient sodium = nutrientExtractor.extractNutrient(NutrientId.SODIUM, nutrients);
        Nutrient totalCarbohydrate = nutrientExtractor.extractNutrient(NutrientId.CARBOHYDRATE, nutrients);
        Nutrient dietaryFiber = nutrientExtractor.extractNutrient(NutrientId.FIBER, nutrients);
        Nutrient sugar = nutrientExtractor.extractNutrient(NutrientId.TOTAL_SUGAR, nutrients);
        Nutrient protein = nutrientExtractor.extractNutrient(NutrientId.TOTAL_PROTEIN, nutrients);

        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setCaloriesValueFormatted(calories.getValueRounded());
        nutritionFacts.setFatValueFormatted(fat.getValueFormatted());
        nutritionFacts.setFatPercentDailyValueFormatted(fat.getPercentDailyValueFormatted());
        nutritionFacts.setSaturatedFatValueFormatted(saturatedFat.getValueFormatted());
        nutritionFacts.setSaturatedFatPercentDailyValueFormatted(saturatedFat.getPercentDailyValueFormatted());
        nutritionFacts.setTransFatValueFormatted(transFat.getValueFormatted());
        nutritionFacts.setCholesterolValueFormatted(cholesterol.getValueFormatted());
        nutritionFacts.setCholesterolPercentDailyValueFormatted(cholesterol.getPercentDailyValueFormatted());
        nutritionFacts.setSodiumValueFormatted(sodium.getValueFormatted());
        nutritionFacts.setSodiumPercentDailyValueFormatted(sodium.getPercentDailyValueFormatted());
        nutritionFacts.setTotalCarbohydrateValueFormatted(totalCarbohydrate.getValueFormatted());
        nutritionFacts.setTotalCarbohydratePercentDailyValueFormatted(totalCarbohydrate.getPercentDailyValueFormatted());
        nutritionFacts.setDietaryFiberValueFormatted(dietaryFiber.getValueFormatted());
        nutritionFacts.setDietaryFiberPercentDailyValueFormatted(dietaryFiber.getPercentDailyValueFormatted());
        nutritionFacts.setSugarValueFormatted(sugar.getValueFormatted());
        nutritionFacts.setProteinValueFormatted(protein.getValueFormatted());

        return nutritionFacts;
    }
}
