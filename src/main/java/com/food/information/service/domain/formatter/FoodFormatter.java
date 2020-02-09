package com.food.information.service.domain.formatter;

import com.food.information.service.domain.builder.nutrientgroup.NutrientGroupBuilder;
import com.food.information.service.domain.builder.nutritionfacts.NutritionFactsBuilder;
import com.food.information.service.domain.calculator.CaloricPyramidCalculator;
import com.food.information.service.domain.calculator.DailyValueCalculator;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.FoodNutritionalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodFormatter {
    private final DailyValueCalculator dailyValueCalculator;
    private final ValueFormatter valueFormatter;
    private final DescriptionsFormatter descriptionsFormatter;
    private final CalorieFormatter calorieFormatter;
    private final NutritionFactsBuilder nutritionFactsBuilder;
    private final CaloricPyramidCalculator caloricPyramidCalculator;
    private final NutrientGroupBuilder nutrientGroupBuilder;

    @Autowired
    public FoodFormatter(DailyValueCalculator dailyValueCalculator, ValueFormatter valueFormatter, DescriptionsFormatter descriptionsFormatter, CalorieFormatter calorieFormatter, NutritionFactsBuilder nutritionFactsBuilder,
                         CaloricPyramidCalculator caloricPyramidCalculator, NutrientGroupBuilder nutrientGroupBuilder) {
        this.dailyValueCalculator = dailyValueCalculator;
        this.valueFormatter = valueFormatter;
        this.descriptionsFormatter = descriptionsFormatter;
        this.calorieFormatter = calorieFormatter;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
    }

    public FoodNutritionalDetails format(Food food) {
        formatNutrientValues(food);

        FoodNutritionalDetails foodNutritionalDetails = new FoodNutritionalDetails();
        foodNutritionalDetails.setShortDescription(food.getShortDescription());
        foodNutritionalDetails.setLongDescription(food.getLongDescription());
        foodNutritionalDetails.setFormattedDescription(descriptionsFormatter.format(food.getLongDescription()));
        foodNutritionalDetails.setFormattedCalories(calorieFormatter.format(food.getNutrients()));
        foodNutritionalDetails.setNutritionFacts(nutritionFactsBuilder.buildNutritionFacts(food.getNutrients()));
        foodNutritionalDetails.setCaloricPyramid(caloricPyramidCalculator.calculateCaloricPyramid(food.getNutrients()));
        foodNutritionalDetails.setNutrientGroups(nutrientGroupBuilder.buildNutrientGroups(food.getNutrients()));

        return foodNutritionalDetails;
    }

    private Food formatNutrientValues(Food food) {
        food.getNutrients().forEach((id, nutrient) -> {
            valueFormatter.formatValue(nutrient);
            dailyValueCalculator.calculateDailyValue(nutrient);
        });

        return food;
    }
}
