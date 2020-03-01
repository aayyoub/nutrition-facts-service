package com.food.information.service.domain;

import com.food.information.service.domain.formatter.SearchTermsFormatter;
import com.food.information.service.domain.model.SuggestedSearchTerm;
import com.food.information.service.services.SearchTermsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchTermsFinder {
    private final SearchTermsService searchTermsService;
    private final SearchTermsFormatter searchTermsFormatter;

    public SearchTermsFinder(SearchTermsService searchTermsService, SearchTermsFormatter searchTermsFormatter) {
        this.searchTermsService = searchTermsService;
        this.searchTermsFormatter = searchTermsFormatter;
    }

    public List<SuggestedSearchTerm> findSearchTerms(String searchTerm) {
        List<SuggestedSearchTerm> searchTerms = searchTermsService.getSearchTerms(searchTerm);

        return searchTermsFormatter.format(searchTerms);
    }
}
