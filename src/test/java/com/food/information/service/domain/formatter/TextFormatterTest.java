package com.food.information.service.domain.formatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextFormatterTest {
    @DataProvider
    public Object[][] descriptionsFormatterDataProvider() {
        return new Object[][]{
                {"Orange juice", "Nutritional facts for orange juice (per 100 grams)"},
                {"ApPlE", "Nutritional facts for apple (per 100 grams)"},
                {"", ""},
                {null, ""},
        };
    }

    @Test(dataProvider = "descriptionsFormatterDataProvider")
    public void testDescriptionsFormatter(String longDescription, String expectedResult) {
        TextFormatter textFormatter = new TextFormatter();
        String actualResult = textFormatter.formatDescription(longDescription);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}