package io.nutritionfacts.service.domain.builder.footnote;

import io.nutritionfacts.service.utility.Translator;
import org.springframework.stereotype.Component;

@Component
public class DisclaimerBuilder {
    private final Translator translator;

    public DisclaimerBuilder(Translator translator) {
        this.translator = translator;
    }

    public String getDisclaimer() {
        return translator.getMessage("default.disclaimer");
    }
}
