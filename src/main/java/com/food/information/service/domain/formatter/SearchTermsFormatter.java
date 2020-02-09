package com.food.information.service.domain.formatter;

import com.food.information.service.domain.model.SuggestedSearchTerm;
import com.food.information.service.domain.seo.SeoUrlBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchTermsFormatter {
    private final SeoUrlBuilder seoUrlBuilder;

    public SearchTermsFormatter(SeoUrlBuilder seoUrlBuilder) {
        this.seoUrlBuilder = seoUrlBuilder;
    }

    public List<SuggestedSearchTerm> format(List<SuggestedSearchTerm> suggestedSearchTerms) {
        suggestedSearchTerms.forEach((searchTerm) -> searchTerm.setUrl(seoUrlBuilder.buildUrl(searchTerm.getValue(), searchTerm.getSearchTerm())));

        return suggestedSearchTerms;
    }
}
