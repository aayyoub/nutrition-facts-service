package io.nutritionfacts.api.domain.builder.footnote;

import io.nutritionfacts.api.util.Translator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisclaimerBuilder {
    private final Translator translator;

    public DisclaimerBuilder(Translator translator) {
        this.translator = translator;
    }

    public String getDisclaimer() {
        return translator.getMessage("default.footnote");
    }
}
