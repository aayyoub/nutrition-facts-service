package io.nutritionfacts.api.domain.builder.footnote;

import io.nutritionfacts.api.util.Translator;
import org.springframework.stereotype.Component;

@Component
public class FootnoteBuilder {
    private final Translator translator;

    public FootnoteBuilder(Translator translator) {
        this.translator = translator;
    }

    public String getFootnote() {
        return translator.getMessage("default.footnote");
    }
}
