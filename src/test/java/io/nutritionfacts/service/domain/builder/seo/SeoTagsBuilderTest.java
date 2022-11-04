package io.nutritionfacts.service.domain.builder.seo;

import io.nutritionfacts.service.domain.model.SeoTags;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeoTagsBuilderTest {
    @DataProvider
    public Object[][] seoTagsBuilderDataProvider() {
        return new Object[][]{
                {"cHeeSecaKe", "Nutrition Facts for Cheesecake", "Nutrition facts and calories for cheesecake. " +
                        "Protein, carbs, and fat information for weight loss, " +
                        "including nutrient values for vitamins, minerals, and recommended daily intake. " +
                        "Trusted nutrition database for healthy eating."},
                {null, "", ""}
        };
    }

    @Test(dataProvider = "seoTagsBuilderDataProvider")
    public void testSeoTagsBuilder(String description, String expectedTitle, String expectedDescription) {
        SeoTagsBuilder seoTagsBuilder = new SeoTagsBuilder();
        SeoTags seoTags = seoTagsBuilder.buildSeoTags(description);

        assertThat(seoTags.getTitle()).isEqualTo(expectedTitle);
        assertThat(seoTags.getDescription()).isEqualTo(expectedDescription);
    }
}
