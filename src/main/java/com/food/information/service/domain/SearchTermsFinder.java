package com.food.information.service.domain;

import com.food.information.service.domain.formatter.SearchTermsFormatter;
import com.food.information.service.domain.model.SuggestedSearchTerm;
import com.food.information.service.services.GetSearchTermsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchTermsFinder {
    private final GetSearchTermsService getSearchTermsService;
    private final SearchTermsFormatter searchTermsFormatter;

    public SearchTermsFinder(GetSearchTermsService getSearchTermsService, SearchTermsFormatter searchTermsFormatter) {
        this.getSearchTermsService = getSearchTermsService;
        this.searchTermsFormatter = searchTermsFormatter;
    }

    public List<SuggestedSearchTerm> findSearchTerms(String searchTerm) {
        List<SuggestedSearchTerm> searchTerms = getSearchTermsService.getSearchTerms(searchTerm);

        return searchTermsFormatter.format(searchTerms);
    }
}
