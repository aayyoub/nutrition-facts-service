package io.nutritionfacts.api.domain.formatter;

import io.nutritionfacts.api.domain.model.SuggestedSearchTerm;
import io.nutritionfacts.api.domain.seo.SeoUrlBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchTermsFormatter {
    private final SeoUrlBuilder seoUrlBuilder;

    public SearchTermsFormatter(SeoUrlBuilder seoUrlBuilder) {
        this.seoUrlBuilder = seoUrlBuilder;
    }

    public List<SuggestedSearchTerm> format(List<SuggestedSearchTerm> suggestedSearchTerms) {
        suggestedSearchTerms.forEach((searchTerm) -> searchTerm.setUrl(seoUrlBuilder.buildUrl(searchTerm.getSearchTerm())));

        return suggestedSearchTerms;
    }
}
