package com.food.information.service.domain.util;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.testutils.builder.NutrientBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class NutrientExtractorTest {
    @DataProvider
    public Object[][] nutrientExtractorDataProvider() {
        return new Object[][]{
                {"221", Map.ofEntries(
                        Map.entry("221", NutrientBuilder.aNutrientBuilder().withId("221").build()),
                        Map.entry("205", NutrientBuilder.aNutrientBuilder().withId("205").build()),
                        Map.entry("204", NutrientBuilder.aNutrientBuilder().withId("204").build()),
                        Map.entry("203", NutrientBuilder.aNutrientBuilder().withId("203").build())),
                        NutrientBuilder.aNutrientBuilder().withId("221").build()
                },
                {"205", Map.ofEntries(
                        Map.entry("221", NutrientBuilder.aNutrientBuilder().withId("221").build()),
                        Map.entry("205", NutrientBuilder.aNutrientBuilder().withId("205").build()),
                        Map.entry("204", NutrientBuilder.aNutrientBuilder().withId("204").build()),
                        Map.entry("203", NutrientBuilder.aNutrientBuilder().withId("203").build())),
                        NutrientBuilder.aNutrientBuilder().withId("205").build()
                },
                {"XXX", Map.ofEntries(
                        Map.entry("203", NutrientBuilder.aNutrientBuilder().withId("203").build())),
                        Nutrient.empty()
                },
                {null, Map.ofEntries(
                        Map.entry("318", NutrientBuilder.aNutrientBuilder().withId("203").build())),
                        Nutrient.empty()
                },
                {null, null, Nutrient.empty()
                }
        };
    }

    @Test(dataProvider = "nutrientExtractorDataProvider")
    public void testNutrientExtractor(String nutrientId, Map<String, Nutrient> nutrients, Nutrient expected) {
        NutrientExtractor nutrientExtractor = new NutrientExtractor();
        Nutrient actual = nutrientExtractor.extractNutrient(nutrientId, nutrients);

        assertThat(actual.getId()).isEqualTo(expected.getId());
    }
}