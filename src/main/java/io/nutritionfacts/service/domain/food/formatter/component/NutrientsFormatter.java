package io.nutritionfacts.service.domain.food.formatter.component;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.Nutrients;
import io.nutritionfacts.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class NutrientsFormatter {
  private final ServingSizeCalculator servingSizeCalculator;
  private final DecimalFormatter decimalFormatter;
  private final NutrientValueFormatter nutrientValueFormatter;
  private final PercentDailyValueCalculator percentDailyValueCalculator;

  public NutrientsFormatter(
      ServingSizeCalculator servingSizeCalculator,
      DecimalFormatter decimalFormatter,
      NutrientValueFormatter nutrientValueFormatter,
      PercentDailyValueCalculator percentDailyValueCalculator
  ) {
    this.servingSizeCalculator = servingSizeCalculator;
    this.decimalFormatter = decimalFormatter;
    this.nutrientValueFormatter = nutrientValueFormatter;
    this.percentDailyValueCalculator = percentDailyValueCalculator;
  }

  public Nutrients formatNutrients(Nutrients nutrients, Set<ServingSize> servingSizes, Integer selectedServingSizeIndex) {
    ServingSize selectedServingSize = servingSizes
        .stream()
        .filter(serving -> serving.getOrder().equals(selectedServingSizeIndex))
        .findAny()
        .orElse(ServingSize.empty());

    //TODO revisit rounding methods for display
    nutrients.nutrients.forEach((id, nutrient) -> {
      nutrient.setValue(servingSizeCalculator.calculateValue(nutrient, selectedServingSize));
      nutrient.setValueRounded(decimalFormatter.formatDecimals(nutrient.getValue(), nutrient.getRoundedToDecimal()));
      nutrient.setValueRoundedWithUnit(nutrientValueFormatter.formatValueRoundedWithUnit(nutrient.getValueRounded(), nutrient.getUnit()));
      nutrient.setValueGaussianRoundedWithUnit(nutrientValueFormatter.formatValueGaussianRoundedWithUnit(nutrient.getValue(), nutrient.getUnit()));
      nutrient.setPercentDailyValue(percentDailyValueCalculator.calculatePercentDailyValue(nutrient.getValue(), nutrient.getDailyValue()));
      nutrient.setPercentDailyValueFormatted(percentDailyValueCalculator.calculatePercentDailyValueFormatted(nutrient.getValue(), nutrient.getDailyValue()));
    });

    return nutrients;
  }
}
