package io.nutritionfacts.service.utility;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class Translator {
    private final ResourceBundleMessageSource resourceBundleMessageSource;

    public Translator(ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;
    }

    public String getMessage(String messageCode) {
        return resourceBundleMessageSource.getMessage(messageCode, null, Locale.ENGLISH);
    }

    public String getMessage(String messageCode, List<String> parameters) {
        return resourceBundleMessageSource.getMessage(messageCode, parameters.toArray(), Locale.ENGLISH);
    }
}
