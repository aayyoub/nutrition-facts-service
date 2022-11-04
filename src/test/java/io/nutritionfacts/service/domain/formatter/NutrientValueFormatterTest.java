package io.nutritionfacts.service.domain.formatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NutrientValueFormatterTest {
    @DataProvider
    public Object[][] valueFormatterDataProvider() {
        return new Object[][]{
                {
                        "1", "g", "1 g"
                },
                {
                        "6.2", "mg", "6.2 mg"
                },
                {
                        null, null, ""
                },
        };
    }

    @Test(dataProvider = "valueFormatterDataProvider")
    public void testValueFormatter(String valueRounded, String unit, String expected) {
        NutrientValueFormatter nutrientValueFormatter = new NutrientValueFormatter();
        String actual = nutrientValueFormatter.formatValueRoundedWithUnit(valueRounded, unit);

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
        NutrientValueFormatter nutrientValueFormatter = new NutrientValueFormatter();
        String actual = nutrientValueFormatter.formatValueGaussianRoundedWithUnit(value, unit);

        assertThat(actual).isEqualTo(expected);
    }
}
