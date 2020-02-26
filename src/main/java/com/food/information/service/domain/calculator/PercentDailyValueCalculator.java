package com.food.information.service.domain.calculator;

import org.springframework.stereotype.Component;

@Component
public class PercentDailyValueCalculator {
    private static final String PERCENT_DAILY_VALUE_FORMATTED = "%.0f%%";
    private static final String DEFAULT_PERCENTAGE = "0%";

    public Double calculatePercentDailyValue(Double value, Double dailyValue) {
        if (value != null && dailyValue != null) {
            return (value / dailyValue) * 100;
        } else {
            return 0.0;
        }
    }

    public String calculatePercentDailyValueFormatted(Double value, Double dailyValue) {
        //TODO fix this value
        return String.format(PERCENT_DAILY_VALUE_FORMATTED, calculatePercentDailyValue(value, dailyValue));
    }
}
