package io.nutritionfacts.service.domain.calculator;

import io.nutritionfacts.service.domain.food.formatter.component.CaloricPyramidCalculator;
import io.nutritionfacts.service.domain.model.CaloricPyramid;
import io.nutritionfacts.service.domain.model.Nutrient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CaloricPyramidCalculatorTest {
    @DataProvider
    public Object[][] caloricPyramidDataProvider() {
        return new Object[][]{
                {Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").value(0.0).tagname("ALC").build()),
                        Map.entry("205", Nutrient.builder().id("205").value(10.0).tagname("CHOCDF").build()),
                        Map.entry("204", Nutrient.builder().id("204").value(10.0).tagname("FAT").build()),
                        Map.entry("203", Nutrient.builder().id("203").value(10.0).tagname("PROCNT").build())),
                        "0%", "24%", "53%", "24%"
                },
                {Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").value(1.0).tagname("ALC").build()),
                        Map.entry("205", Nutrient.builder().id("205").value(0.0).tagname("CHOCDF").build()),
                        Map.entry("204", Nutrient.builder().id("204").value(0.0).tagname("FAT").build()),
                        Map.entry("203", Nutrient.builder().id("203").value(0.0).tagname("PROCNT").build())),
                        "100%", "0%", "0%", "0%"
                },
                {Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").value(1.0).tagname("ALC").build())),
                        "100%", "0%", "0%", "0%"
                },
                {null, "0%", "0%", "0%", "0%"
                },
        };
    }

    @Test(dataProvider = "caloricPyramidDataProvider")
    public void testCaloricPyramidCalculator(Map<String, Nutrient> nutrients, String expectedAlcoholPercentage, String expectedCarbohydratePercentage,
                                             String expectedFatPercentage, String expectedProteinPercentage) {
        CaloricPyramidCalculator caloricPyramidCalculator = new CaloricPyramidCalculator(new NutrientExtractor());
        CaloricPyramid actualResult = caloricPyramidCalculator.calculateCaloricPyramid(nutrients);

        assertThat(actualResult.getAlcoholPercentage()).isEqualTo(expectedAlcoholPercentage);
        assertThat(actualResult.getCarbohydratePercentage()).isEqualTo(expectedCarbohydratePercentage);
        assertThat(actualResult.getFatPercentage()).isEqualTo(expectedFatPercentage);
        assertThat(actualResult.getProteinPercentage()).isEqualTo(expectedProteinPercentage);
    }
}
