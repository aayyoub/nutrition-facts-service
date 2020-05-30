package io.nutritionfacts.api.domain.formatter;

import io.nutritionfacts.api.domain.model.Nutrient;
import io.nutritionfacts.api.domain.util.NutrientExtractor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CalorieFormatterTest {
    @DataProvider
    public Object[][] calorieFormatterDataProvider() {
        return new Object[][]{
                {
                        Map.ofEntries(
                                Map.entry("208", Nutrient.builder().id("208").description("Energy").value(150.0).build())
                        ), "150 calories"
                },
                {
                        Map.ofEntries(
                                Map.entry("208", Nutrient.builder().id("208").description("Energy").value(150.2).build())
                        ), "150 calories"
                },
                {
                        Map.ofEntries(
                                Map.entry("203", Nutrient.builder().id("203").description("Protein").value(4.0).build()),
                                Map.entry("204", Nutrient.builder().id("204").description("Total lipid (fat)").value(5.0).build()),
                                Map.entry("208", Nutrient.builder().id("208").description("Energy").value(52.5).build())
                        ), "53 calories"
                },
                {
                        Map.ofEntries(
                                Map.entry("203", Nutrient.builder().id("203").description("Protein").value(4.0).build())
                        ), "0 calories",
                },
        };
    }

    @Test(dataProvider = "calorieFormatterDataProvider")
    public void testCalorieFormatter(Map<String, Nutrient> nutrients, String expectedResult) {
        CalorieFormatter calorieFormatter = new CalorieFormatter(new NutrientExtractor());
        String actualResult = calorieFormatter.format(nutrients);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}