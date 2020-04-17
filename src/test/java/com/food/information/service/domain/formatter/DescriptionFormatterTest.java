package com.food.information.service.domain.formatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptionFormatterTest {
    @DataProvider
    public Object[][] descriptionsFormatterDataProvider() {
        return new Object[][]{
                {"Orange juice", "Orange Juice"},
                {"aPPLE", "APPLE"},
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