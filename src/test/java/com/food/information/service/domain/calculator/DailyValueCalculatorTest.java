package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.testutils.builder.NutrientBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyValueCalculatorTest {
    @DataProvider
    public Object[][] dailyValueCalculatorDataProvider() {
        return new Object[][]{
                {NutrientBuilder.aNutrientBuilder().withValue(5.0).withDailyValue(5.0).build(), 100.0},
                {NutrientBuilder.aNutrientBuilder().withValue(1.0).withDailyValue(4.0).build(), 25.0},
                {NutrientBuilder.aNutrientBuilder().withValue(0.0).withDailyValue(100.0).build(), 0.0},
                {NutrientBuilder.aNutrientBuilder().withValue(5.0).withDailyValue(1.0).build(), 500.0},
                {NutrientBuilder.aNutrientBuilder().withValue(null).withDailyValue(100.0).build(), 0.0},
                {NutrientBuilder.aNutrientBuilder().withValue(5.0).withDailyValue(null).build(), 0.0},
        };
    }

    @Test(dataProvider = "dailyValueCalculatorDataProvider")
    public void testDailyValueCalculator(Nutrient nutrient, Double expectedDailyValue) {
        DailyValueCalculator dailyValueCalculator = new DailyValueCalculator();
        Nutrient actual = dailyValueCalculator.calculateDailyValue(nutrient);

        assertThat(actual.getPercentDailyValue()).isEqualTo(expectedDailyValue);
    }
}