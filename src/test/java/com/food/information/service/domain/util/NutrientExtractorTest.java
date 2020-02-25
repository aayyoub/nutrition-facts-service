package com.food.information.service.domain.util;

import com.food.information.service.domain.model.Nutrient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class NutrientExtractorTest {
    @DataProvider
    public Object[][] nutrientExtractorDataProvider() {
        return new Object[][]{
                {"221", Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").build()),
                        Map.entry("205", Nutrient.builder().id("205").build()),
                        Map.entry("204", Nutrient.builder().id("204").build()),
                        Map.entry("203", Nutrient.builder().id("203").build())),
                        Nutrient.builder().id("221").build()
                },
                {"205", Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").build()),
                        Map.entry("205", Nutrient.builder().id("205").build()),
                        Map.entry("204", Nutrient.builder().id("204").build()),
                        Map.entry("203", Nutrient.builder().id("203").build())),
                        Nutrient.builder().id("205").build()
                },
                {"XXX", Map.ofEntries(
                        Map.entry("203", Nutrient.builder().id("203").build())),
                        Nutrient.empty()
                },
                {null, Map.ofEntries(
                        Map.entry("318", Nutrient.builder().id("203").build())),
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