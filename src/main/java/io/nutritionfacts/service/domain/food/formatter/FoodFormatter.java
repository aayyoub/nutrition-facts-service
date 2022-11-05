package io.nutritionfacts.service.domain.food.formatter;

import io.nutritionfacts.service.domain.food.formatter.component.DisclaimerFormatter;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.Grouper;
import io.nutritionfacts.service.domain.food.formatter.component.NutritionFactsBuilder;
import io.nutritionfacts.service.domain.food.formatter.component.CaloricPyramidCalculator;
import io.nutritionfacts.service.domain.food.formatter.component.CalorieFormatter;
import io.nutritionfacts.service.domain.food.formatter.component.DescriptionFormatter;
import io.nutritionfacts.service.domain.food.formatter.component.NutrientsFormatter;
import io.nutritionfacts.service.domain.model.CaloricPyramid;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;
import io.nutritionfacts.service.domain.model.NutritionFacts;
import io.nutritionfacts.service.domain.model.ServingSize;
import io.nutritionfacts.service.domain.food.formatter.component.ServingSizeSelector;
import java.util.Map;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class FoodFormatter {
  private final NutrientsFormatter nutrientsFormatter;
  private final DescriptionFormatter descriptionFormatter;
  private final CalorieFormatter calorieFormatter;
  private final ServingSizeSelector servingSizeSelector;
  private final NutritionFactsBuilder nutritionFactsBuilder;
  private final CaloricPyramidCalculator caloricPyramidCalculator;
  private final Grouper grouper;
  private final DisclaimerFormatter disclaimerFormatter;

  public FoodFormatter(
      NutrientsFormatter nutrientsFormatter,
      DescriptionFormatter descriptionFormatter,
      CalorieFormatter calorieFormatter,
      ServingSizeSelector servingSizeSelector,
      NutritionFactsBuilder nutritionFactsBuilder,
      CaloricPyramidCalculator caloricPyramidCalculator,
      Grouper grouper,
      DisclaimerFormatter disclaimerFormatter
  ) {
    this.nutrientsFormatter = nutrientsFormatter;
    this.descriptionFormatter = descriptionFormatter;
    this.calorieFormatter = calorieFormatter;
    this.servingSizeSelector = servingSizeSelector;
    this.nutritionFactsBuilder = nutritionFactsBuilder;
    this.caloricPyramidCalculator = caloricPyramidCalculator;
    this.grouper = grouper;
    this.disclaimerFormatter = disclaimerFormatter;
  }

  public Food formatFood(Food food, Integer servingSize) {
    food.setNutrients(formatNutrients(food, servingSize));
    food.setSelectedServingSize(getSelectedServingSize(food, servingSize));
    food.setServingSizes(getServingSizes(food));
    food.setDescription(getDescription(food));
    food.setCalories(getCalories(food));
    food.setCaloricPyramid(getCaloricPyramid(food));
    food.setNutritionFacts(getNutritionFacts(food));
    food.setNutrientGroups(getNutrientGroups(food));
    food.setDisclaimer(getDisclaimer());

    return food;
  }

  private Map<String, Nutrient> formatNutrients(Food food, Integer servingSizeIndex) {
    return nutrientsFormatter.formatNutrients(food.getNutrients(), food.getServingSizes(), servingSizeIndex);
  }

  private ServingSize getSelectedServingSize(Food food, Integer servingSize) {
    return servingSizeSelector.getSelectedServingSize(food.getServingSizes(), servingSize);
  }

  private Set<ServingSize> getServingSizes(Food food) {
    return food.getServingSizes();
  }

  private String getDescription(Food food) {
    return descriptionFormatter.formatDescription(food.getName());
  }

  private String getCalories(Food food) {
    return calorieFormatter.format(food.getNutrients());
  }

  private CaloricPyramid getCaloricPyramid(Food food) {
    return caloricPyramidCalculator.calculateCaloricPyramid(food.getNutrients());
  }

  private NutritionFacts getNutritionFacts(Food food) {
    return nutritionFactsBuilder.buildNutritionFacts(food.getNutrients(), food.getSelectedServingSize());
  }

  private List<NutrientGroup> getNutrientGroups(Food food) {
    return grouper.group(food.getNutrients());
  }

  private String getDisclaimer() {
    return disclaimerFormatter.getDisclaimer();
  }
}
