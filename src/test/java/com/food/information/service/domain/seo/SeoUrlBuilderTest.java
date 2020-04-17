package com.food.information.service.domain.seo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeoUrlBuilderTest {
    @DataProvider
    public Object[][] seoUrlBuilderDataProvider() {
        return new Object[][]{
                {"01007", "Cheese, camembert", "https://www.nutritionfacts.io/cheese-camembert"},
                {"03808", "Infant formula, MEAD JOHNSON, ENFAMIL, LIPIL, with iron, powder, with ARA and DHA", "https://www.nutritionfacts" +
                        ".io/infant-formula-mead-johnson-enfamil-lipil-with" +
                        "-iron-powder-with-ara-and-dha"},
                {"12345", "   This foOoOd iz! wild   --- ~`!@#$%^&*()_-[]{}\\|+='\";:?/.>,<", "https://www.nutritionfacts.io/this-fooood-iz-wild-percent-and-"}
        };
    }

    @Test(dataProvider = "seoUrlBuilderDataProvider")
    public void testSeoUrlBuilder(String foodId, String description, String expectedResult) {
        String domain = "https://www.nutritionfacts.io";
        SeoUrlBuilder seoUrlBuilder = new SeoUrlBuilder(domain);
        String actualResult = seoUrlBuilder.buildUrl(description);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
