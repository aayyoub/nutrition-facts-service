package io.nutritionfacts.service.domain.food.formatter;

import io.nutritionfacts.service.domain.food.formatter.component.DisclaimerFormatter;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.NutrientGrouper;
import io.nutritionfacts.service.domain.food.formatter.component.NutritionFactsBuilder;
import io.nutritionfacts.service.domain.food.formatter.component.CaloricPyramidCalculator;
import io.nutritionfacts.service.domain.food.formatter.component.CalorieFormatter;
import io.nutritionfacts.service.domain.food.formatter.component.DescriptionFormatter;
import io.nutritionfacts.service.domain.food.formatter.component.NutrientsFormatter;
import io.nutritionfacts.service.domain.model.CaloricPyramid;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;
import io.nutritionfacts.service.domain.model.FoodSummary;
import io.nutritionfacts.service.domain.model.NutrientGroup;
import io.nutritionfacts.service.domain.model.Nutrients;
import io.nutritionfacts.service.domain.model.NutritionFacts;
import io.nutritionfacts.service.domain.model.ServingSize;
import io.nutritionfacts.service.domain.food.formatter.component.ServingSizeSelector;
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
  private final NutrientGrouper nutrientGrouper;
  private final DisclaimerFormatter disclaimerFormatter;

  public FoodFormatter(
      NutrientsFormatter nutrientsFormatter,
      DescriptionFormatter descriptionFormatter,
      CalorieFormatter calorieFormatter,
      ServingSizeSelector servingSizeSelector,
      NutritionFactsBuilder nutritionFactsBuilder,
      CaloricPyramidCalculator caloricPyramidCalculator,
      NutrientGrouper nutrientGrouper,
      DisclaimerFormatter disclaimerFormatter
  ) {
    this.nutrientsFormatter = nutrientsFormatter;
    this.descriptionFormatter = descriptionFormatter;
    this.calorieFormatter = calorieFormatter;
    this.servingSizeSelector = servingSizeSelector;
    this.nutritionFactsBuilder = nutritionFactsBuilder;
    this.caloricPyramidCalculator = caloricPyramidCalculator;
    this.nutrientGrouper = nutrientGrouper;
    this.disclaimerFormatter = disclaimerFormatter;
  }

  public Food formatFood(FoodSummary foodSummary, Integer servingSize) {
    return new Food(
        getFoodId(foodSummary),
        getName(foodSummary),
        getDescription(foodSummary),
        getServingSizes(foodSummary),
        getNutrients(foodSummary, servingSize),
        getSelectedServingSize(foodSummary, servingSize),
        getCalories(foodSummary),
        getNutritionFacts(foodSummary, servingSize),
        getCaloricPyramid(foodSummary),
        getNutrientGroups(foodSummary),
        getDisclaimer()
    );
  }

  private FoodId getFoodId(FoodSummary foodSummary) {
    return foodSummary.getId();
  }

  private String getName(FoodSummary foodSummary) {
    return foodSummary.getName();
  }

  private String getDescription(FoodSummary foodSummary) {
    return descriptionFormatter.formatDescription(foodSummary.getName());
  }

  private Nutrients getNutrients(FoodSummary foodSummary, Integer servingSizeIndex) {
    return nutrientsFormatter.formatNutrients(foodSummary.getNutrients(), foodSummary.getServingSizes(), servingSizeIndex);
  }

  private Set<ServingSize> getServingSizes(FoodSummary foodSummary) {
    return foodSummary.getServingSizes();
  }

  private ServingSize getSelectedServingSize(FoodSummary foodSummary, Integer servingSize) {
    return servingSizeSelector.getSelectedServingSize(foodSummary.getServingSizes(), servingSize);
  }

  private String getCalories(FoodSummary foodSummary) {
    return calorieFormatter.format(foodSummary.getNutrients());
  }

  private CaloricPyramid getCaloricPyramid(FoodSummary foodSummary) {
    return caloricPyramidCalculator.calculateCaloricPyramid(foodSummary.getNutrients());
  }

  private NutritionFacts getNutritionFacts(FoodSummary foodSummary, Integer servingSize) {
    return nutritionFactsBuilder.build(foodSummary.getNutrients(), getSelectedServingSize(foodSummary, servingSize));
  }

  private List<NutrientGroup> getNutrientGroups(FoodSummary foodSummary) {
    return nutrientGrouper.group(foodSummary.getNutrients());
  }

  private String getDisclaimer() {
    return disclaimerFormatter.getDisclaimer();
  }
}
