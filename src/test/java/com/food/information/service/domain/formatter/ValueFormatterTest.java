package com.food.information.service.domain.formatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueFormatterTest {
    @DataProvider
    public Object[][] valueFormatterDataProvider() {
        return new Object[][]{
                {
                        1.0, "g", "1 g"
                },
                {
                        6.0, "mg", "6 mg"
                },
                {
                        null, null, ""
                },
        };
    }

    @Test(dataProvider = "valueFormatterDataProvider")
    public void testValueFormatter(Double value, String unit, String expected) {
        ValueFormatter valueFormatter = new ValueFormatter();
        String actual = valueFormatter.formatValue(value, unit);

        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] valueFormatterWithoutSpaceDataProvider() {
        return new Object[][]{
                {
                        1.0, "g", "1g"
                },
                {
                        6.0, "mg", "6mg"
                },
                {
                        null, null, ""
                },
        };
    }

    @Test(dataProvider = "valueFormatterWithoutSpaceDataProvider")
    public void testValueFormatterWithoutSpace(Double value, String unit, String expected) {
        ValueFormatter valueFormatter = new ValueFormatter();
        String actual = valueFormatter.formatValueWithoutSpace(value, unit);

        assertThat(actual).isEqualTo(expected);
    }
}