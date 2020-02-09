package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.CaloricPyramid;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.util.NutrientExtractor;
import com.food.information.service.domain.util.NutrientId;
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
        Nutrient fat = nutrientExtractor.extractNutrient(NutrientId.FAT, nutrients);
        Nutrient protein = nutrientExtractor.extractNutrient(NutrientId.PROTEIN, nutrients);

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
        caloricPyramid.setAlcoholPercentage(alcoholPercentage);
        caloricPyramid.setCarbohydratePercentage(carbohydratePercentage);
        caloricPyramid.setFatPercentage(fatPercentage);
        caloricPyramid.setProteinPercentage(proteinPercentage);

        caloricPyramid.setAlcoholPercentageFormatted(String.format(FORMATTED_PERCENTAGE, alcoholPercentage));
        caloricPyramid.setCarbohydratePercentageFormatted(String.format(FORMATTED_PERCENTAGE, carbohydratePercentage));
        caloricPyramid.setFatPercentageFormatted(String.format(FORMATTED_PERCENTAGE, fatPercentage));
        caloricPyramid.setProteinPercentageFormatted(String.format(FORMATTED_PERCENTAGE, proteinPercentage));

        caloricPyramid.setCaloriesFromAlcohol(caloriesFromAlcohol);
        caloricPyramid.setCaloriesFromCarbohydrates(caloriesFromCarbohydrate);
        caloricPyramid.setCaloriesFromFat(caloriesFromFat);
        caloricPyramid.setCaloriesFromProtein(caloriesFromProtein);

        return caloricPyramid;
    }
}
