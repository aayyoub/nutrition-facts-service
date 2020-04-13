package com.food.information.service.domain.formatter;

import com.food.information.service.domain.builder.nutrientgroup.NutrientGroupBuilder;
import com.food.information.service.domain.builder.nutritionalstatements.NutritionalStatementsBuilder;
import com.food.information.service.domain.builder.nutritionfacts.NutritionFactsBuilder;
import com.food.information.service.domain.calculator.CaloricPyramidCalculator;
import com.food.information.service.domain.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodFormatter {
    private final NutrientsFormatter nutrientsFormatter;
    private final DescriptionFormatter descriptionFormatter;
    private final CalorieFormatter calorieFormatter;
    private final NutritionFactsBuilder nutritionFactsBuilder;
    private final CaloricPyramidCalculator caloricPyramidCalculator;
    private final NutrientGroupBuilder nutrientGroupBuilder;
    private final NutritionalStatementsBuilder nutritionalStatementsBuilder;

    @Autowired
    public FoodFormatter(NutrientsFormatter nutrientsFormatter, DescriptionFormatter descriptionFormatter,
                         CalorieFormatter calorieFormatter, NutritionFactsBuilder nutritionFactsBuilder,
                         CaloricPyramidCalculator caloricPyramidCalculator, NutrientGroupBuilder nutrientGroupBuilder,
                         NutritionalStatementsBuilder nutritionalStatementsBuilder) {
        this.nutrientsFormatter = nutrientsFormatter;
        this.descriptionFormatter = descriptionFormatter;
        this.calorieFormatter = calorieFormatter;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
        this.nutritionalStatementsBuilder = nutritionalStatementsBuilder;
    }

    public Food formatFood(Food food, Integer selectedServingSizeIndex) {
        food.setNutrientsPerServingSize(nutrientsFormatter.formatNutrients(food.getNutrients(), food.getServingSizes(), selectedServingSizeIndex));
        food.setDescription(descriptionFormatter.formatDescription(food.getName()));
        food.setCalories(calorieFormatter.format(food.getNutrientsPerServingSize()));
        food.setNutritionFacts(nutritionFactsBuilder.buildNutritionFacts(food.getNutrientsPerServingSize()));
        food.setCaloricPyramid(caloricPyramidCalculator.calculateCaloricPyramid(food.getNutrientsPerServingSize()));
        food.setNutrientGroups(nutrientGroupBuilder.buildNutrientGroups(food.getNutrientsPerServingSize()));
        food.setNutritionalStatements(nutritionalStatementsBuilder.buildNutritionalStatements(food.getNutrients()));
        food.setServingSizes(food.getServingSizes());

        return food;
    }
}
