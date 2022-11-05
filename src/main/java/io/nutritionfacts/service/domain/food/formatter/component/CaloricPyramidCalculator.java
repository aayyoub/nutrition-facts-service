package io.nutritionfacts.service.domain.food.formatter.component;

import io.nutritionfacts.service.domain.model.CaloricPyramid;
import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.model.Nutrients;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CaloricPyramidCalculator {
    private static final Double CALORIES_PER_GRAM_OF_ALCOHOL = 7.0;
    private static final Double CALORIES_PER_GRAM_OF_CARBOHYDRATE = 4.0;
    private static final Double CALORIES_PER_GRAM_OF_FAT = 9.0;
    private static final Double CALORIES_PER_GRAM_OF_PROTEIN = 4.0;
    private static final String FORMATTED_PERCENTAGE = "%.0f%%";

    public CaloricPyramid calculateCaloricPyramid(Nutrients nutrients) {
        Optional<Nutrient> alcohol = nutrients.get(NutrientId.ALCOHOL);
        Optional<Nutrient> carbohydrate = nutrients.get(NutrientId.CARBOHYDRATE);
        Optional<Nutrient> fat = nutrients.get(NutrientId.TOTAL_FAT);
        Optional<Nutrient> protein = nutrients.get(NutrientId.TOTAL_PROTEIN);

        double gramsOfAlcohol = alcohol.isPresent() ? alcohol.get().getValue() : 0.0;
        double gramsOfCarbohydrate = carbohydrate.isPresent() ? carbohydrate.get().getValue() : 0.0;
        double gramsOfFat = fat.isPresent() ? fat.get().getValue() : 0.0;
        double gramsOfProtein = protein.isPresent() ? protein.get().getValue() : 0.0;

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
