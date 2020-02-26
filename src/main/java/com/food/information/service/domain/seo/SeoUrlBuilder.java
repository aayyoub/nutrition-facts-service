package com.food.information.service.domain.seo;

import org.springframework.stereotype.Component;

@Component
public class SeoUrlBuilder {
    private static final String PATTERN = "food/%s/%s";

    public String buildUrl(String foodId, String description) {
        String descriptionCleaned = description
                .toLowerCase()
                .strip()
                .replaceAll("[ ,_+]", "-")
                .replaceAll("%", "-percent-")
                .replaceAll("&", "-and-")
                .replaceAll("[^a-z0-9_-]", "")
                .replaceAll("-+", "-");

        return String.format(PATTERN, foodId, descriptionCleaned);
    }
}
