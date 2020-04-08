package com.food.information.service.domain.formatter;

import org.springframework.stereotype.Component;

@Component
public class DescriptionFormatter {
    private static final String FORMATTED_DESCRIPTION = "Nutrition facts for %s";

    public String formatDescription(String description) {
        if (description == null || description.length() == 0) {
            return "";
        }

        return String.format(FORMATTED_DESCRIPTION, description.toLowerCase());
    }
}
