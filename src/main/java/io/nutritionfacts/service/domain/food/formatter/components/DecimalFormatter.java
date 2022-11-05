package io.nutritionfacts.service.domain.food.formatter.components;

import org.springframework.stereotype.Component;

@Component
public class DecimalFormatter {
    public String formatDecimals(Double value, Integer roundedToDecimal) {
        return switch (roundedToDecimal) {
            case 1 -> String.format("%.1f", value);
            case 2 -> String.format("%.2f", value);
            case 3 -> String.format("%.3f", value);
            default -> String.format("%.0f", value);
        };
    }

}
