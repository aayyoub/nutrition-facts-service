package com.food.information.service.domain.formatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptionsFormatterTest {
    @DataProvider
    public Object[][] descriptionsFormatterDataProvider() {
        return new Object[][]{
                {"Orange juice", "Nutritional information for orange juice (per 100 grams)"},
                {"ApPlE", "Nutritional information for apple (per 100 grams)"},
                {"", ""},
                {null, ""},
        };
    }

    @Test(dataProvider = "descriptionsFormatterDataProvider")
    public void testDescriptionsFormatter(String longDescription, String expectedResult) {
        DescriptionsFormatter descriptionsFormatter = new DescriptionsFormatter();
        String actualResult = descriptionsFormatter.format(longDescription);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}