package com.food.information.service.domain.formatter;

import com.food.information.service.domain.builder.nutrientgroup.NutrientGroupBuilder;
import com.food.information.service.domain.builder.nutritionalstatements.NutritionStatementsBuilder;
import com.food.information.service.domain.builder.nutritionfacts.NutritionFactsBuilder;
import com.food.information.service.domain.builder.seo.SeoTagsBuilder;
import com.food.information.service.domain.calculator.CaloricPyramidCalculator;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.util.ServingSizeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodFormatter {
    private final NutrientsFormatter nutrientsFormatter;
    private final DescriptionFormatter descriptionFormatter;
    private final CalorieFormatter calorieFormatter;
    private final ServingSizeSelector servingSizeSelector;
    private final NutritionFactsBuilder nutritionFactsBuilder;
    private final CaloricPyramidCalculator caloricPyramidCalculator;
    private final NutrientGroupBuilder nutrientGroupBuilder;
    private final NutritionStatementsBuilder nutritionStatementsBuilder;
    private final SeoTagsBuilder seoTagsBuilder;

    @Autowired
    public FoodFormatter(NutrientsFormatter nutrientsFormatter, DescriptionFormatter descriptionFormatter,
                         CalorieFormatter calorieFormatter, ServingSizeSelector servingSizeSelector,
                         NutritionFactsBuilder nutritionFactsBuilder, CaloricPyramidCalculator caloricPyramidCalculator,
                         NutrientGroupBuilder nutrientGroupBuilder, NutritionStatementsBuilder nutritionStatementsBuilder,
                         SeoTagsBuilder seoTagsBuilder) {
        this.nutrientsFormatter = nutrientsFormatter;
        this.descriptionFormatter = descriptionFormatter;
        this.calorieFormatter = calorieFormatter;
        this.servingSizeSelector = servingSizeSelector;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
        this.nutritionStatementsBuilder = nutritionStatementsBuilder;
        this.seoTagsBuilder = seoTagsBuilder;
    }

    public Food formatFood(Food food, Integer selectedServingSizeIndex) {
        food.setNutrientsPerServingSize(nutrientsFormatter.formatNutrients(food.getNutrients(), food.getServingSizes(), selectedServingSizeIndex));
        food.setDescription(descriptionFormatter.formatDescription(food.getName()));
        food.setCalories(calorieFormatter.format(food.getNutrientsPerServingSize()));
        food.setServingSize(servingSizeSelector.getSelectedServingSize(food.getServingSizes(), selectedServingSizeIndex));
        food.setNutritionFacts(nutritionFactsBuilder.buildNutritionFacts(food.getNutrientsPerServingSize()));
        food.setCaloricPyramid(caloricPyramidCalculator.calculateCaloricPyramid(food.getNutrientsPerServingSize()));
        food.setNutrientGroups(nutrientGroupBuilder.buildNutrientGroups(food.getNutrientsPerServingSize()));
        food.setNutritionStatements(nutritionStatementsBuilder.buildNutritionStatements(food.getNutrients()));
        food.setServingSizes(food.getServingSizes());
        food.setSeoTags(seoTagsBuilder.buildSeoTags(food.getDescription()));

        return food;
    }
}
