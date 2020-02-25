package com.food.information.service.domain.formatter;

import com.food.information.service.domain.builder.nutrientgroup.NutrientGroupBuilder;
import com.food.information.service.domain.builder.nutritionfacts.NutritionFactsBuilder;
import com.food.information.service.domain.calculator.CaloricPyramidCalculator;
import com.food.information.service.domain.calculator.PercentDailyValueCalculator;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.FoodNutritionalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodFormatter {
    private final PercentDailyValueCalculator percentDailyValueCalculator;
    private final ValueFormatter valueFormatter;
    private final DecimalFormatter decimalFormatter;
    private final DescriptionsFormatter descriptionsFormatter;
    private final CalorieFormatter calorieFormatter;
    private final NutritionFactsBuilder nutritionFactsBuilder;
    private final CaloricPyramidCalculator caloricPyramidCalculator;
    private final NutrientGroupBuilder nutrientGroupBuilder;

    @Autowired
    public FoodFormatter(PercentDailyValueCalculator percentDailyValueCalculator, ValueFormatter valueFormatter, DecimalFormatter decimalFormatter, DescriptionsFormatter descriptionsFormatter, CalorieFormatter calorieFormatter
            , NutritionFactsBuilder nutritionFactsBuilder,
                         CaloricPyramidCalculator caloricPyramidCalculator, NutrientGroupBuilder nutrientGroupBuilder) {
        this.percentDailyValueCalculator = percentDailyValueCalculator;
        this.valueFormatter = valueFormatter;
        this.decimalFormatter = decimalFormatter;
        this.descriptionsFormatter = descriptionsFormatter;
        this.calorieFormatter = calorieFormatter;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
    }

    public FoodNutritionalDetails formatFood(Food food) {
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
            nutrient.setValueFormatted(valueFormatter.formatValue(nutrient.getValue(), nutrient.getUnit()));
            nutrient.setValueRounded(decimalFormatter.formatDecimals(nutrient.getValue(), nutrient.getRoundedToDecimal()));
            nutrient.setPercentDailyValue(percentDailyValueCalculator.calculatePercentDailyValue(nutrient.getValue(), nutrient.getDailyValue()));
            nutrient.setPercentDailyValueFormatted(percentDailyValueCalculator.calculatePercentDailyValueFormatted(nutrient.getValue(), nutrient.getDailyValue()));
        });

        return food;
    }
}
