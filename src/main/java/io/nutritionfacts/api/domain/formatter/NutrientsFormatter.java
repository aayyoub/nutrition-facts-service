package io.nutritionfacts.api.domain.formatter;

import io.nutritionfacts.api.domain.calculator.PercentDailyValueCalculator;
import io.nutritionfacts.api.domain.calculator.ServingSizeCalculator;
import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class NutrientsFormatter {
    private final ServingSizeCalculator servingSizeCalculator;
    private final DecimalFormatter decimalFormatter;
    private final ValueFormatter valueFormatter;
    private final PercentDailyValueCalculator percentDailyValueCalculator;

    public NutrientsFormatter(ServingSizeCalculator servingSizeCalculator, DecimalFormatter decimalFormatter,
                              ValueFormatter valueFormatter, PercentDailyValueCalculator percentDailyValueCalculator) {
        this.servingSizeCalculator = servingSizeCalculator;
        this.decimalFormatter = decimalFormatter;
        this.valueFormatter = valueFormatter;
        this.percentDailyValueCalculator = percentDailyValueCalculator;
    }

    public Map<String, Nutrient> formatNutrients(Map<String, Nutrient> nutrients, Set<ServingSize> servingSizes, Integer selectedServingSizeIndex) {
        ServingSize selectedServingSize = servingSizes
                .stream()
                .filter(serving -> serving.getOrder().equals(selectedServingSizeIndex))
                .findAny()
                .orElse(ServingSize.empty());

        nutrients.forEach((id, nutrient) -> {
            nutrient.setValue(servingSizeCalculator.calculateValue(nutrient, selectedServingSize));
            nutrient.setValueRounded(decimalFormatter.formatDecimals(nutrient.getValue(), nutrient.getRoundedToDecimal()));
            nutrient.setValueFormatted(valueFormatter.formatValue(nutrient.getValue(), nutrient.getUnit()));
            nutrient.setValueFormattedWithoutSpaces(valueFormatter.formatValueWithoutSpace(nutrient.getValue(), nutrient.getUnit()));
            nutrient.setPercentDailyValue(percentDailyValueCalculator.calculatePercentDailyValue(nutrient.getValue(), nutrient.getDailyValue()));
            nutrient.setPercentDailyValueFormatted(percentDailyValueCalculator.calculatePercentDailyValueFormatted(nutrient.getValue(), nutrient.getDailyValue()));
        });

        return nutrients;
    }
}
