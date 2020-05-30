package io.nutritionfacts.api.domain;

import io.nutritionfacts.api.domain.formatter.SearchTermsFormatter;
import io.nutritionfacts.api.domain.model.SuggestedSearchTerm;
import io.nutritionfacts.api.services.SearchTermsService;
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
