package com.food.information.service.domain.formatter;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;

@Component
public class TextFormatter {
    private static final String FORMATTED_DESCRIPTION = "Nutritional facts for %s (per 100 grams)";

    public String formatTitle(String longDescription) {
        if (longDescription == null || longDescription.length() == 0) {
            return "";
        }

        return String.format(FORMATTED_DESCRIPTION, WordUtils.capitalizeFully(longDescription));
    }

    public String formatDescription(String longDescription) {
        if (longDescription == null || longDescription.length() == 0) {
            return "";
        }

        return String.format(FORMATTED_DESCRIPTION, WordUtils.capitalizeFully(longDescription));
    }
}
