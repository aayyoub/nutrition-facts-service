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
public class ValueAnalyzerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    ValueAnalyzer valueAnalyzer;

    @DataProvider
    public Object[][] valueAnalyzerDataProvider() {
        return new Object[][]{
                {
                        Nutrient.builder().commonName("Sugar").value(0.0).valueFormattedWithoutSpaces("0g").isBeneficial(false).targetLessThanValue(5.0).targetMoreThanValue(22.5).build(),
                        NutritionStatement.builder().isBeneficial(true).statement("Low in sugar (contains 0g of sugar)").build()
                },
                {
                        Nutrient.builder().commonName("Sugar").value(23.0).valueFormattedWithoutSpaces("23g").isBeneficial(false).targetLessThanValue(5.0).targetMoreThanValue(22.5).build(),
                        NutritionStatement.builder().isBeneficial(false).statement("High in sugar (contains 23g of sugar)").build()
                },
                {
                        Nutrient.builder().commonName("Fiber").value(5.0).valueFormattedWithoutSpaces("5g").isBeneficial(true).targetLessThanValue(null).targetMoreThanValue(3.0).build(),
                        NutritionStatement.builder().isBeneficial(true).statement("High in fiber (contains 5g of fiber)").build()
                },
                {
                        Nutrient.builder().commonName("Total fat").value(2.0).valueFormattedWithoutSpaces("2g").isBeneficial(false).targetLessThanValue(3.0).targetMoreThanValue(17.5).build(),
                        NutritionStatement.builder().isBeneficial(true).statement("Low in total fat (contains 2g of total fat)").build()
                },
                {
                        Nutrient.builder().commonName("Total fat").value(30.0).valueFormattedWithoutSpaces("30g").isBeneficial(false).targetLessThanValue(3.0).targetMoreThanValue(17.5).build(),
                        NutritionStatement.builder().isBeneficial(false).statement("High in total fat (contains 30g of total fat)").build()
                }
        };
    }

    @Test(dataProvider = "valueAnalyzerDataProvider")
    public void testValueAnalyzer(Nutrient nutrient, NutritionStatement expected) {
        Optional<NutritionStatement> actual = valueAnalyzer.getNutritionStatement(nutrient);

        assertThat(actual.isPresent());
        assertThat(actual.get()).isEqualTo(expected);
    }
}
