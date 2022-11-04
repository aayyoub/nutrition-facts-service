package io.nutritionfacts.service.domain.formatter;

import io.nutritionfacts.service.domain.builder.footnote.DisclaimerBuilder;
import io.nutritionfacts.service.domain.builder.nutrientgroup.NutrientGroupBuilder;
import io.nutritionfacts.service.domain.builder.nutritionfacts.NutritionFactsBuilder;
import io.nutritionfacts.service.domain.builder.seo.SeoTagsBuilder;
import io.nutritionfacts.service.domain.calculator.CaloricPyramidCalculator;
import io.nutritionfacts.service.domain.model.CaloricPyramid;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;
import io.nutritionfacts.service.domain.model.NutritionFacts;
import io.nutritionfacts.service.domain.model.SeoTags;
import io.nutritionfacts.service.domain.model.ServingSize;
import io.nutritionfacts.service.domain.util.ServingSizeSelector;
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
    private final DisclaimerBuilder disclaimerBuilder;

    @Autowired
    public FoodFormatter(NutrientsFormatter nutrientsFormatter, DescriptionFormatter descriptionFormatter,
                         CalorieFormatter calorieFormatter, ServingSizeSelector servingSizeSelector,
                         NutritionFactsBuilder nutritionFactsBuilder, CaloricPyramidCalculator caloricPyramidCalculator,
                         NutrientGroupBuilder nutrientGroupBuilder, SeoTagsBuilder seoTagsBuilder, DisclaimerBuilder disclaimerBuilder) {
        this.nutrientsFormatter = nutrientsFormatter;
        this.descriptionFormatter = descriptionFormatter;
        this.calorieFormatter = calorieFormatter;
        this.servingSizeSelector = servingSizeSelector;
        this.nutritionFactsBuilder = nutritionFactsBuilder;
        this.caloricPyramidCalculator = caloricPyramidCalculator;
        this.nutrientGroupBuilder = nutrientGroupBuilder;
        this.seoTagsBuilder = seoTagsBuilder;
        this.disclaimerBuilder = disclaimerBuilder;
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
        String disclaimer = disclaimerBuilder.getDisclaimer();

        food.setNutrientsPerServingSize(nutrientsPerServingSize);
        food.setDescription(description);
        food.setCalories(calories);
        food.setServingSizes(servingSizes);
        food.setSelectedServingSize(selectedServingSize);
        food.setNutritionFacts(nutritionFacts);
        food.setCaloricPyramid(caloricPyramid);
        food.setNutrientGroups(nutrientGroups);
        food.setSeoTags(seoTags);
        food.setDisclaimer(disclaimer);

        return food;
    }
}
