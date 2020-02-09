package com.food.information.service.domain.formatter;

import org.springframework.stereotype.Component;

@Component
public class DescriptionsFormatter {
    private static final String FORMATTED_DESCRIPTION = "Nutritional information for %s (per 100 grams)";

    public String format(String longDescription) {
        if (longDescription == null || longDescription.length() == 0) {
            return "";
        }

        return String.format(FORMATTED_DESCRIPTION, longDescription.toLowerCase());
    }
}
