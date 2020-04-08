package com.food.information.service.domain.calculator;

import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.ServingSize;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServingSizeCalculatorTest {
    @DataProvider
    public Object[][] servingSizeCalculatorDataProvider() {
        return new Object[][]{
                {
                        Nutrient.builder().value(1.0).build(),
                        ServingSize.builder().gramWeight(1.5).order(1).build(),
                        0.015
                },
                {
                        Nutrient.builder().value(5.0).build(),
                        ServingSize.builder().gramWeight(227.0).order(5).build(),
                        11.35
                },
                {
                        Nutrient.builder().value(5.0).build(),
                        ServingSize.builder().gramWeight(150.0).order(0).build(),
                        5.0
                },
        };
    }

    @Test(dataProvider = "servingSizeCalculatorDataProvider")
    public void testServingSizeCalculator(Nutrient nutrient, ServingSize servingSize, Double expected) {
        ServingSizeCalculator servingSizeCalculator = new ServingSizeCalculator();
        Double actual = servingSizeCalculator.calculateValue(nutrient, servingSize);

        assertThat(actual).isEqualTo(expected);
    }
}