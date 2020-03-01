package com.food.information.service.domain.formatter;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;

@Component
public class TextFormatter {
    private static final String FORMATTED_DESCRIPTION = "Nutrition facts for %s (per 100 grams)";

    public String formatTitle(String title) {
        if (title == null || title.length() == 0) {
            return "";
        }

        return WordUtils.capitalizeFully(title);
    }

    public String formatDescription(String longDescription) {
        if (longDescription == null || longDescription.length() == 0) {
            return "";
        }

        return String.format(FORMATTED_DESCRIPTION, longDescription.toLowerCase());
    }
}
