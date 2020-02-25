package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.Nutrient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyValueCalculatorTest {
    @DataProvider
    public Object[][] dailyValueCalculatorDataProvider() {
        return new Object[][]{
                {Nutrient.builder().value(5.0).dailyValue(5.0).build(), 100.0},
                {Nutrient.builder().value(1.0).dailyValue(4.0).build(), 25.0},
                {Nutrient.builder().value(0.0).dailyValue(100.0).build(), 0.0},
                {Nutrient.builder().value(5.0).dailyValue(1.0).build(), 500.0},
                {Nutrient.builder().value(null).dailyValue(100.0).build(), 0.0},
                {Nutrient.builder().value(5.0).dailyValue(null).build(), 0.0},
        };
    }

    @Test(dataProvider = "dailyValueCalculatorDataProvider")
    public void testDailyValueCalculator(Nutrient nutrient, Double expectedDailyValue) {
        DailyValueCalculator dailyValueCalculator = new DailyValueCalculator();
        Nutrient actual = dailyValueCalculator.calculateDailyValue(nutrient);

        assertThat(actual.getPercentDailyValue()).isEqualTo(expectedDailyValue);
    }
}