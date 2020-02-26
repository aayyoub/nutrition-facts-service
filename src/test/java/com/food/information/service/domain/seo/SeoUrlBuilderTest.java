package com.food.information.service.domain.seo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeoUrlBuilderTest {
    @DataProvider
    public Object[][] seoUrlBuilderDataProvider() {
        return new Object[][]{
                {"01007", "Cheese, camembert", "food/01007/cheese-camembert"},
                {"03808", "Infant formula, MEAD JOHNSON, ENFAMIL, LIPIL, with iron, powder, with ARA and DHA", "food/03808/infant-formula-mead-johnson-enfamil-lipil-with" +
                        "-iron-powder-with-ara-and-dha"},
                {"12345", "   This foOoOd iz! wild   --- ~`!@#$%^&*()_-[]{}\\|+='\";:?/.>,<", "food/12345/this-fooood-iz-wild-percent-and-"}
        };
    }

    @Test(dataProvider = "seoUrlBuilderDataProvider")
    public void testSeoUrlBuilder(String foodId, String description, String expectedResult) {
        SeoUrlBuilder seoUrlBuilder = new SeoUrlBuilder();
        String actualResult = seoUrlBuilder.buildUrl(foodId, description);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
