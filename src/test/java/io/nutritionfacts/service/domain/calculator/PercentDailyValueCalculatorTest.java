package io.nutritionfacts.service.domain.calculator;

import io.nutritionfacts.service.domain.food.formatter.component.PercentDailyValueCalculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PercentDailyValueCalculatorTest {
    @DataProvider
    public Object[][] dailyValueCalculatorDataProvider() {
        return new Object[][]{
                {5.0, 5.0, "100%"},
                {1.0, 4.0, "25%"},
                {0.0, 100.0, ""},
                {5.0, 1.0, "500%"},
                {null, 100.0, ""},
                {5.0, null, ""},
        };
    }

    @Test(dataProvider = "dailyValueCalculatorDataProvider")
    public void testDailyValueCalculator(Double value, Double dailyValue, String expected) {
        PercentDailyValueCalculator percentDailyValueCalculator = new PercentDailyValueCalculator();
        String actual = percentDailyValueCalculator.calculatePercentDailyValueFormatted(value, dailyValue);

        assertThat(actual).isEqualTo(expected);
    }
}
