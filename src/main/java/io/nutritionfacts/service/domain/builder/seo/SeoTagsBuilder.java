package io.nutritionfacts.service.domain.builder.seo;

import io.nutritionfacts.service.domain.model.SeoTags;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;

@Component
public class SeoTagsBuilder {
    private static final String SEO_TITLE = "Nutrition Facts for %s";
    private static final String SEO_DESCRIPTION = "Nutrition facts and calories for %s. " +
            "Protein, carbs, and fat information for weight loss, " +
            "including nutrient values for vitamins, minerals, and recommended daily intake. " +
            "Trusted nutrition database for healthy eating.";

    public SeoTags buildSeoTags(String description) {
        SeoTags seoTags = new SeoTags();

        if (description != null && description.length() > 0) {
            seoTags.setTitle(String.format(SEO_TITLE, WordUtils.capitalizeFully(description)));
            seoTags.setDescription(String.format(SEO_DESCRIPTION, StringUtils.lowerCase(description)));
        } else {
            seoTags.setTitle("");
            seoTags.setDescription("");
        }

        return seoTags;
    }
}
