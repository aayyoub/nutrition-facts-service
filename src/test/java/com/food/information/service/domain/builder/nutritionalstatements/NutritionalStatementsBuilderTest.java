package com.food.information.service.domain.builder.nutritionalstatements;

import com.food.information.service.FoodApplication;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutritionalStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = FoodApplication.class)
public class NutritionalStatementsBuilderTest extends AbstractTestNGSpringContextTests {
    @Autowired
    NutritionalStatementsBuilder nutritionalStatementsBuilder;

    @DataProvider
    public Object[][] nutritionalStatementDataProvider() {
        return new Object[][]{
                {
                        Map.ofEntries(Map.entry("269", Nutrient.builder().id("269").value(23.0).valueFormattedWithoutSpaces("23g").build())),
                        NutritionalStatement.builder().isBeneficial(false).analysisStatement("Contains 23g of total sugar").build()
                },
                {
                        Map.ofEntries(Map.entry("269", Nutrient.builder().id("269").value(4.0).valueFormattedWithoutSpaces("4g").build())),
                        NutritionalStatement.builder().isBeneficial(true).analysisStatement("Low sugar").build()
                },
                {
                        Map.ofEntries(Map.entry("269", Nutrient.builder().id("269").value(0.0).valueFormattedWithoutSpaces("0g").build())),
                        NutritionalStatement.builder().isBeneficial(true).analysisStatement("No sugar").build()
                },
                {
                        Map.ofEntries(Map.entry("204", Nutrient.builder().id("204").value(17.6).valueFormattedWithoutSpaces("17g").build())),
                        NutritionalStatement.builder().isBeneficial(false).analysisStatement("Contains 17g of total fat").build()
                },
                {
                        Map.ofEntries(Map.entry("204", Nutrient.builder().id("204").value(2.9).valueFormattedWithoutSpaces("2g").build())),
                        NutritionalStatement.builder().isBeneficial(true).analysisStatement("Low total fat").build()
                },
                {
                        Map.ofEntries(Map.entry("606", Nutrient.builder().id("606").value(5.1).valueFormattedWithoutSpaces("5g").build())),
                        NutritionalStatement.builder().isBeneficial(false).analysisStatement("Contains 5g of saturated fat").build()
                },
                {
                        Map.ofEntries(Map.entry("307", Nutrient.builder().id("307").value(250.0).valueFormattedWithoutSpaces("250mg").build())),
                        NutritionalStatement.builder().isBeneficial(true).analysisStatement("Low sodium").build()
                },
                {
                        Map.ofEntries(Map.entry("307", Nutrient.builder().id("307").value(1600.0).valueFormattedWithoutSpaces("1600g").build())),
                        NutritionalStatement.builder().isBeneficial(false).analysisStatement("Contains 1600g of sodium").build()
                },
        };
    }

    @Test(dataProvider = "nutritionalStatementDataProvider")
    public void testNutritionalStatementsBuilder(Map<String, Nutrient> nutrients, NutritionalStatement expected) {
        NutritionalStatement actual = nutritionalStatementsBuilder.buildNutritionalStatements(nutrients).get(0);

        assertThat(actual).isEqualTo(expected);
    }
}
