package com.food.information.service.domain.formatter;

import com.food.information.service.domain.builder.nutrientgroup.NutrientGroupBuilder;
import com.food.information.service.domain.builder.nutritionfacts.NutritionFactsBuilder;
import com.food.information.service.domain.builder.seo.SeoTagsBuilder;
import com.food.information.service.domain.calculator.CaloricPyramidCalculator;
import com.food.information.service.domain.model.CaloricPyramid;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutrientGroup;
import com.food.information.service.domain.model.NutritionFacts;
import com.food.information.service.domain.model.SeoTags;
import com.food.information.service.domain.model.ServingSize;
import com.food.information.service.domain.util.ServingSizeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class FoodFormatter {
    private final NutrientsFormatter nutrientsFormatter;
    private final DescriptionFormatter descriptionFormatter;
    private final CalorieFormatter calorieFormatter;
    private final ServingSizeSelector servingSizeSelector;
    private final NutritionFactsBuilder nutritionFactsBuilder;
    private final CaloricPyramidCalculator caloricPyramidCalculator;
    private final NutrientGroupBuilder nutrientGroupBuilder;
    private final SeoTagsBuilder seoTagsBuilder;

    @Autowired
    public FoodFormatter(NutrientsFormatter nutrientsFormatter, DescriptionFormatter descriptionFormatter,
                         CalorieFormatter calorieFormatter, ServingSizeSelector servingSizeSelector,
                         NutritionFactsBuilder nutritionFactsBuilder, CaloricPyramidCalculator caloricPyramidCalculator,
                         NutrientGroupBuilder nutrientGroupBuilder, SeoTagsBuilder seoTagsBuilder) {
        this.nutrientsFormatter = nutrientsFormatter;
        this.descriptionFormatter = descriptionFormatter;
        this.calorieFormatter = calorieFormatter;
        this.servingSizeSelector = servingSizeSelector;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
        this.seoTagsBuilder = seoTagsBuilder;
    }

    public Food formatFood(Food food, Integer selectedServingSizeIndex) {
        Map<String, Nutrient> nutrientsPerServingSize = nutrientsFormatter.formatNutrients(food.getNutrients(), food.getServingSizes(), selectedServingSizeIndex);
        String description = descriptionFormatter.formatDescription(food.getName());
        String calories = calorieFormatter.format(nutrientsPerServingSize);
        Set<ServingSize> servingSizes = food.getServingSizes();
        ServingSize selectedServingSize = servingSizeSelector.getSelectedServingSize(servingSizes, selectedServingSizeIndex);
        NutritionFacts nutritionFacts = nutritionFactsBuilder.buildNutritionFacts(nutrientsPerServingSize, selectedServingSize);
        CaloricPyramid caloricPyramid = caloricPyramidCalculator.calculateCaloricPyramid(nutrientsPerServingSize);
        List<NutrientGroup> nutrientGroups = nutrientGroupBuilder.buildNutrientGroups(nutrientsPerServingSize);
        SeoTags seoTags = seoTagsBuilder.buildSeoTags(description);

        food.setNutrientsPerServingSize(nutrientsPerServingSize);
        food.setDescription(description);
        food.setCalories(calories);
        food.setServingSizes(servingSizes);
        food.setSelectedServingSize(selectedServingSize);
        food.setNutritionFacts(nutritionFacts);
        food.setCaloricPyramid(caloricPyramid);
        food.setNutrientGroups(nutrientGroups);
        food.setSeoTags(seoTags);

        return food;
    }
}
