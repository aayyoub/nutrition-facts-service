package io.nutritionfacts.service.domain.food.formatter.components;

import io.nutritionfacts.service.utility.Translator;
import org.springframework.stereotype.Component;

@Component
public class DisclaimerFormatter {
    private final Translator translator;

    public DisclaimerFormatter(Translator translator) {
        this.translator = translator;
    }

    public String getDisclaimer() {
        return translator.getMessage("default.disclaimer");
    }
}
