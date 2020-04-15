package com.food.information.service.domain.builder.nutritionalstatements.analyzer;

import com.food.information.service.FoodApplication;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = FoodApplication.class)
public class DailyValueAnalyzerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    DailyValueAnalyzer dailyValueAnalyzer;

    @DataProvider
    public Object[][] dailyValueAnalyzerDataProvider() {
        return new Object[][]{
                {
                        Nutrient.builder().commonName("Vitamin D").dailyValue(25.0).percentDailyValueFormatted("25%").isBeneficial(true).targetLessThanDailyValue(Optional.empty()).targetMoreThanDailyValue(Optional.of(20.0)).build(),
                        NutritionStatement.builder().isBeneficial(true).statement("Contains 25% daily value of Vitamin D").build()
                },
                {
                        Nutrient.builder().commonName("Vitamin D").dailyValue(0.0).percentDailyValueFormatted("0%").isBeneficial(true).targetLessThanDailyValue(Optional.of(1.0)).targetMoreThanDailyValue(Optional.of(20.0)).build(),
                        NutritionStatement.builder().isBeneficial(false).statement("Contains 0% daily value of Vitamin D").build()
                },
        };
    }

    @Test(dataProvider = "dailyValueAnalyzerDataProvider")
    public void testNutritionalStatementsBuilder(Nutrient nutrient, NutritionStatement expected) {
        Optional<NutritionStatement> actual = dailyValueAnalyzer.getNutritionStatement(nutrient);

        assertThat(actual.isPresent());
        assertThat(actual.get()).isEqualTo(expected);
    }
}
