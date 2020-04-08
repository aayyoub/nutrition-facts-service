package com.food.information.service.domain.formatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptionFormatterTest {
    @DataProvider
    public Object[][] descriptionsFormatterDataProvider() {
        return new Object[][]{
                {"Orange juice", "Nutrition facts for orange juice (per 100 grams)"},
                {"ApPlE", "Nutrition facts for apple (per 100 grams)"},
                {"", ""},
                {null, ""},
        };
    }

    @Test(dataProvider = "descriptionsFormatterDataProvider")
    public void testDescriptionsFormatter(String longDescription, String expectedResult) {
        DescriptionFormatter descriptionFormatter = new DescriptionFormatter();
        String actualResult = descriptionFormatter.formatDescription(longDescription);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}