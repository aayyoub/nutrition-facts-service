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
    private final TextFormatter textFormatter;
    private final CalorieFormatter calorieFormatter;
    private final NutritionFactsBuilder nutritionFactsBuilder;
    private final CaloricPyramidCalculator caloricPyramidCalculator;
    private final NutrientGroupBuilder nutrientGroupBuilder;

    @Autowired
    public FoodFormatter(PercentDailyValueCalculator percentDailyValueCalculator, ValueFormatter valueFormatter,
                         DecimalFormatter decimalFormatter, TextFormatter textFormatter,
                         CalorieFormatter calorieFormatter, NutritionFactsBuilder nutritionFactsBuilder,
                         CaloricPyramidCalculator caloricPyramidCalculator, NutrientGroupBuilder nutrientGroupBuilder) {
        this.percentDailyValueCalculator = percentDailyValueCalculator;
        this.valueFormatter = valueFormatter;
        this.decimalFormatter = decimalFormatter;
        this.textFormatter = textFormatter;
        this.calorieFormatter = calorieFormatter;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
    }

    public FoodNutritionalDetails formatFood(Food food) {
        Food formattedFood = formatNutrientValues(food);

        FoodNutritionalDetails foodNutritionalDetails = new FoodNutritionalDetails();
        foodNutritionalDetails.setShortDescription(formattedFood.getShortDescription());
        foodNutritionalDetails.setLongDescription(textFormatter.formatTitle(formattedFood.getLongDescription()));
        foodNutritionalDetails.setFormattedDescription(textFormatter.formatDescription(formattedFood.getLongDescription()));
        foodNutritionalDetails.setFormattedCalories(calorieFormatter.format(formattedFood.getNutrients()));
        foodNutritionalDetails.setNutritionFacts(nutritionFactsBuilder.buildNutritionFacts(formattedFood.getNutrients()));
        foodNutritionalDetails.setCaloricPyramid(caloricPyramidCalculator.calculateCaloricPyramid(formattedFood.getNutrients()));
        foodNutritionalDetails.setNutrientGroups(nutrientGroupBuilder.buildNutrientGroups(formattedFood.getNutrients()));
        foodNutritionalDetails.setServingSizes(food.getServingSizes());

        return foodNutritionalDetails;
    }

    private Food formatNutrientValues(Food food) {
        food.getNutrients().forEach((id, nutrient) -> {
            //TODO refactor the below and add unit tests
            nutrient.setValueRounded(decimalFormatter.formatDecimals(nutrient.getValue(),
                    nutrient.getRoundedToDecimal()));

            nutrient.setValueFormatted(valueFormatter.formatValue(nutrient.getValue(), nutrient.getUnit()));

            nutrient.setPercentDailyValue(percentDailyValueCalculator.calculatePercentDailyValue(nutrient.getValue(),
                            nutrient.getDailyValue()));

            nutrient.setPercentDailyValueFormatted(percentDailyValueCalculator.calculatePercentDailyValueFormatted(nutrient.getValue(), nutrient.getDailyValue()));
        });

        return food;
    }
}
