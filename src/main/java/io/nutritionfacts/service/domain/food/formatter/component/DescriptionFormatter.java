package io.nutritionfacts.service.domain.food.formatter.component;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;

@Component
public class DescriptionFormatter {
    public String formatDescription(String description) {
        if (description != null && description.length() > 0) {
            return WordUtils.capitalizeFully(description);
        }

        return "";
    }
}
