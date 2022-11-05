package io.nutritionfacts.service.domain.util;

import io.nutritionfacts.service.domain.model.Nutrient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//TODO revisit these tests
public class NutrientExtractorTest {
    @DataProvider
    public Object[][] nutrientExtractorDataProvider() {
        return new Object[][]{
                {"221", Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").build()),
                        Map.entry("205", Nutrient.builder().id("205").build()),
                        Map.entry("204", Nutrient.builder().id("204").build()),
                        Map.entry("203", Nutrient.builder().id("203").build())),
                        Optional.ofNullable(Nutrient.builder().id("221").build())
                },
                {"205", Map.ofEntries(
                        Map.entry("221", Nutrient.builder().id("221").build()),
                        Map.entry("205", Nutrient.builder().id("205").build()),
                        Map.entry("204", Nutrient.builder().id("204").build()),
                        Map.entry("203", Nutrient.builder().id("203").build())),
                        Optional.ofNullable(Nutrient.builder().id("205").build())
                },
                {"XXX", Map.ofEntries(
                        Map.entry("203", Nutrient.builder().id("203").build())),
                        Optional.empty()
                },
                {null, Map.ofEntries(
                        Map.entry("318", Nutrient.builder().id("203").build())),
                        Optional.empty()
                },
                {null, null, Optional.empty()
                }
        };
    }

    @Test(dataProvider = "nutrientExtractorDataProvider")
    public void testNutrientExtractor(String nutrientId, Map<String, Nutrient> nutrients, Optional<Nutrient> expected) {
        NutrientExtractor nutrientExtractor = new NutrientExtractor();
        Optional<Nutrient> actual = nutrientExtractor.extract(nutrientId, nutrients);

        if (expected.isPresent()) {
            assertThat(actual.get().getId()).isEqualTo(expected.get().getId());
        } else {
            assertThat(expected).isEqualTo(Optional.empty());
        }
    }
}
