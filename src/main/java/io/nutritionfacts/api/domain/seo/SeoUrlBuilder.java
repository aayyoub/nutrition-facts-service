package io.nutritionfacts.api.domain.seo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SeoUrlBuilder {
    private static final String PATTERN = "%s/%s";
    private final String domain;

    public SeoUrlBuilder(@Value("${domain}") String domain) {
        this.domain = domain;
    }

    public String buildUrl(String description) {
        return String.format(PATTERN, domain, formatDescription(description));
    }

    public String formatDescription(String description) {
        return description
                .toLowerCase()
                .strip()
                .replaceAll("[ ,_+]", "-")
                .replaceAll("%", "-percent-")
                .replaceAll("&", "-and-")
                .replaceAll("[^a-z0-9_-]", "")
                .replaceAll("-+", "-");
    }
}
