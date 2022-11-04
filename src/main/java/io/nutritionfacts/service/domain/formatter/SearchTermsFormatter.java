package io.nutritionfacts.service.domain.formatter;

import io.nutritionfacts.service.domain.model.SuggestedSearchTerm;
import io.nutritionfacts.service.domain.seo.SeoUrlBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchTermsFormatter {
    private final SeoUrlBuilder seoUrlBuilder;

    public SearchTermsFormatter(SeoUrlBuilder seoUrlBuilder) {
        this.seoUrlBuilder = seoUrlBuilder;
    }

    public List<SuggestedSearchTerm> format(List<SuggestedSearchTerm> suggestedSearchTerms) {
        suggestedSearchTerms.forEach((searchTerm) -> {
            searchTerm.setUrl(seoUrlBuilder.buildUrl(searchTerm.getSearchTerm()));
            searchTerm.setFoodName(seoUrlBuilder.getFoodName(searchTerm.getSearchTerm()));
        });

        return suggestedSearchTerms;
    }
}
