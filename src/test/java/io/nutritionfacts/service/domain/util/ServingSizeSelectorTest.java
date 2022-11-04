package io.nutritionfacts.service.domain.util;

import io.nutritionfacts.service.domain.model.ServingSize;
import io.nutritionfacts.service.exception.InvalidServingSizeException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;

public class ServingSizeSelectorTest {
    @DataProvider
    public Object[][] servingSizeSelectorDataProvider() {
        return new Object[][]{
                {
                        Set.of(
                                ServingSize.builder().order(1).description("1.0 cup").build(),
                                ServingSize.builder().order(2).description("2.0 cups").build(),
                                ServingSize.builder().order(3).description("3.0 cups").build()
                        ), 1, "1.0 cup"
                },
                {
                        Set.of(
                                ServingSize.builder().order(1).description("1.0 cup").build(),
                                ServingSize.builder().order(2).description("2.0 cups").build(),
                                ServingSize.builder().order(3).description("3.0 cups").build()
                        ), 3, "3.0 cups"
                },
                {
                        Set.of(
                                ServingSize.builder().order(0).description("100 grams").build(),
                                ServingSize.builder().order(1).description("1.0 cup").build(),
                                ServingSize.builder().order(2).description("2.0 cups").build(),
                                ServingSize.builder().order(3).description("3.0 cups").build()
                        ), 0, "100 grams"
                }
        };
    }

    @Test(dataProvider = "servingSizeSelectorDataProvider")
    public void testServingSizeSelector(Set<ServingSize> servingSizes, Integer selectedServingSize, String expected) {
        ServingSizeSelector servingSizeSelector = new ServingSizeSelector();
        ServingSize actual = servingSizeSelector.getSelectedServingSize(servingSizes, selectedServingSize);

        assertThat(actual.getDescription()).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] invalidServingSizeSelectorDataProvider() {
        return new Object[][]{
                {
                        Set.of(
                                ServingSize.builder().order(1).description("1.0 cup").build(),
                                ServingSize.builder().order(2).description("2.0 cups").build(),
                                ServingSize.builder().order(3).description("3.0 cups").build()
                        ), 4
                },
                {
                        emptySet(), 4
                }
        };
    }

    @Test(dataProvider = "invalidServingSizeSelectorDataProvider", expectedExceptions = InvalidServingSizeException.class)
    public void testInvalidServingSize(Set<ServingSize> servingSizes, Integer selectedServingSize) {
        ServingSizeSelector servingSizeSelector = new ServingSizeSelector();
        servingSizeSelector.getSelectedServingSize(servingSizes, selectedServingSize);
    }
}
