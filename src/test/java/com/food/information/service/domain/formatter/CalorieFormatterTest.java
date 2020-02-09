//package com.food.information.service.domain.formatter;
//
//import com.food.information.service.domain.model.Nutrient;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class CalorieFormatterTest {
//    @DataProvider
//    public Object[][] calorieFormatterDataProvider() {
//        return new Object[][]{
//                {Collections.singletonList(new Nutrient(150.0, "g", "Energy", "ENERC_KCAL", null, null, null, 1)),
//                        "150 calories (per 100 grams)"},
//                {Collections.singletonList(new Nutrient(150.2, "g", "Energy", "ENERC_KCAL", null, null, null, 1)),
//                        "150 calories (per 100 grams)"},
//                {Arrays.asList(
//                        new Nutrient(4.0, "g", "Protein", "PROCNT", null, null, null, 1),
//                        new Nutrient(5.0, "g", "Total lipid (fat)", "FAT", null, null, null, 2),
//                        new Nutrient(52.5, "g", "Energy", "ENERC_KCAL", null, null, null, 3)),
//                        "53 calories (per 100 grams)"},
//                {Collections.singletonList(
//                        new Nutrient(4.0, "g", "Protein", "PROCNT", null, null, null, 1)),
//                        ""}
//        };
//    }
//
//    @Test(dataProvider = "calorieFormatterDataProvider")
//    public void testCalorieFormatter(List<Nutrient> nutrients, String expectedResult) {
//        CalorieFormatter calorieFormatter = new CalorieFormatter();
//        String actualResult = calorieFormatter.format(nutrients);
//
//        assertThat(actualResult).isEqualTo(expectedResult);
//    }
//}