package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.CaloricPyramid;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.util.NutrientExtractor;
import com.food.information.service.testutils.builder.NutrientBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CaloricPyramidCalculatorTest {
    @DataProvider
    public Object[][] caloricPyramidDataProvider() {
        return new Object[][]{
                {Map.ofEntries(
                        Map.entry("221", NutrientBuilder.aNutrientBuilder().withId("221").withValue(0.0).withTagname("ALC").build()),
                        Map.entry("205", NutrientBuilder.aNutrientBuilder().withId("205").withValue(10.0).withTagname("CHOCDF").build()),
                        Map.entry("204", NutrientBuilder.aNutrientBuilder().withId("204").withValue(10.0).withTagname("FAT").build()),
                        Map.entry("203", NutrientBuilder.aNutrientBuilder().withId("203").withValue(10.0).withTagname("PROCNT").build())),
                        0.0, 24.0, 53.0, 24.0
                },
                {Map.ofEntries(
                        Map.entry("221", NutrientBuilder.aNutrientBuilder().withId("221").withValue(1.0).withTagname("ALC").build()),
                        Map.entry("205", NutrientBuilder.aNutrientBuilder().withId("205").withValue(0.0).withTagname("CHOCDF").build()),
                        Map.entry("204", NutrientBuilder.aNutrientBuilder().withId("204").withValue(0.0).withTagname("FAT").build()),
                        Map.entry("203", NutrientBuilder.aNutrientBuilder().withId("203").withValue(0.0).withTagname("PROCNT").build())),
                        100.0, 0.0, 0.0, 0.0
                },
                {Map.ofEntries(
                        Map.entry("221", NutrientBuilder.aNutrientBuilder().withId("221").withValue(1.0).withTagname("ALC").build())),
                        100.0, 0.0, 0.0, 0.0
                },
                {null, 0.0, 0.0, 0.0, 0.0
                },
        };
    }

    @Test(dataProvider = "caloricPyramidDataProvider")
    public void testCaloricPyramidCalculator(Map<String, Nutrient> nutrients, double expectedAlcoholPercentage, double expectedCarbohydratePercentage,
                                             double expectedFatPercentage, double expectedProteinPercentage) {
        CaloricPyramidCalculator caloricPyramidCalculator = new CaloricPyramidCalculator(new NutrientExtractor());
        CaloricPyramid actualResult = caloricPyramidCalculator.calculateCaloricPyramid(nutrients);

        assertThat(actualResult.getAlcoholPercentage()).isEqualTo(expectedAlcoholPercentage);
        assertThat(actualResult.getCarbohydratePercentage()).isEqualTo(expectedCarbohydratePercentage);
        assertThat(actualResult.getFatPercentage()).isEqualTo(expectedFatPercentage);
        assertThat(actualResult.getProteinPercentage()).isEqualTo(expectedProteinPercentage);
    }
}