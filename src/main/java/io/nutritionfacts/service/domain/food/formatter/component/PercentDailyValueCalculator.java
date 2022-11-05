package io.nutritionfacts.service.domain.food.formatter.component;

import org.springframework.stereotype.Component;

@Component
public class PercentDailyValueCalculator {
    private static final String PERCENT_DAILY_VALUE_FORMATTED = "%.0f%%";

    public Double calculatePercentDailyValue(Double value, Double dailyValue) {
        if (value != null && dailyValue != null) {
            return (value / dailyValue) * 100;
        } else {
            return 0.0;
        }
    }

    public String calculatePercentDailyValueFormatted(Double value, Double dailyValue) {
        Double percentDailyValue = calculatePercentDailyValue(value, dailyValue);
        if (percentDailyValue > 0.0) {
            return String.format(PERCENT_DAILY_VALUE_FORMATTED, percentDailyValue);
        } else {
            return "";
        }
    }
}
