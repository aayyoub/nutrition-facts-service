package io.nutritionfacts.api.domain.calculator;

import io.nutritionfacts.api.domain.model.CaloricPyramid;
import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.util.NutrientExtractor;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CaloricPyramidCalculator {
    private static final Double CALORIES_PER_GRAM_OF_ALCOHOL = 7.0;
    private static final Double CALORIES_PER_GRAM_OF_CARBOHYDRATE = 4.0;
    private static final Double CALORIES_PER_GRAM_OF_FAT = 9.0;
    private static final Double CALORIES_PER_GRAM_OF_PROTEIN = 4.0;
    private static final String FORMATTED_PERCENTAGE = "%.0f%%";
    private final NutrientExtractor nutrientExtractor;

    public CaloricPyramidCalculator(NutrientExtractor nutrientExtractor) {
        this.nutrientExtractor = nutrientExtractor;
    }

    public CaloricPyramid calculateCaloricPyramid(Map<String, Nutrient> nutrients) {
        Nutrient alcohol = nutrientExtractor.extractNutrient(NutrientId.ALCOHOL, nutrients);
        Nutrient carbohydrate = nutrientExtractor.extractNutrient(NutrientId.CARBOHYDRATE, nutrients);
        Nutrient fat = nutrientExtractor.extractNutrient(NutrientId.TOTAL_FAT, nutrients);
        Nutrient protein = nutrientExtractor.extractNutrient(NutrientId.TOTAL_PROTEIN, nutrients);

        double gramsOfAlcohol = alcohol.getValue();
        double gramsOfCarbohydrate = carbohydrate.getValue();
        double gramsOfFat = fat.getValue();
        double gramsOfProtein = protein.getValue();

        double caloriesFromAlcohol = gramsOfAlcohol * CALORIES_PER_GRAM_OF_ALCOHOL;
        double caloriesFromCarbohydrate = gramsOfCarbohydrate * CALORIES_PER_GRAM_OF_CARBOHYDRATE;
        double caloriesFromFat = gramsOfFat * CALORIES_PER_GRAM_OF_FAT;
        double caloriesFromProtein = gramsOfProtein * CALORIES_PER_GRAM_OF_PROTEIN;

        double totalCalories = caloriesFromAlcohol + caloriesFromCarbohydrate + caloriesFromFat + caloriesFromProtein;

        double alcoholPercentage = (double) Math.round(caloriesFromAlcohol / totalCalories * 100);
        double carbohydratePercentage = (double) Math.round(caloriesFromCarbohydrate / totalCalories * 100);
        double fatPercentage = (double) Math.round(caloriesFromFat / totalCalories * 100);
        double proteinPercentage = (double) Math.round(caloriesFromProtein / totalCalories * 100);

        CaloricPyramid caloricPyramid = new CaloricPyramid();
        caloricPyramid.setAlcoholPercentage(String.format(FORMATTED_PERCENTAGE, alcoholPercentage));
        caloricPyramid.setCarbohydratePercentage(String.format(FORMATTED_PERCENTAGE, carbohydratePercentage));
        caloricPyramid.setFatPercentage(String.format(FORMATTED_PERCENTAGE, fatPercentage));
        caloricPyramid.setProteinPercentage(String.format(FORMATTED_PERCENTAGE, proteinPercentage));

        return caloricPyramid;
    }
}
