package io.nutritionfacts.api.domain.formatter;

import org.springframework.stereotype.Component;

@Component
public class DecimalFormatter {
    public String formatDecimals(Double value, Integer roundedToDecimal) {
        switch (roundedToDecimal) {
            case 1:
                return String.format("%.1f", value);
            case 2:
                return String.format("%.2f", value);
            case 3:
                return String.format("%.3f", value);
            default:
                return String.format("%.0f", value);
        }
    }

}
