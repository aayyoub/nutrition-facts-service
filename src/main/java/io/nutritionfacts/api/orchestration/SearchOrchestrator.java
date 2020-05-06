package io.nutritionfacts.api.orchestration;

import io.nutritionfacts.api.api.model.SearchTermRequest;
import io.nutritionfacts.api.domain.SearchTermsFinder;
import io.nutritionfacts.api.domain.model.SuggestedSearchTerm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchOrchestrator {
    private final SearchTermsFinder searchTermsFinder;

    public SearchOrchestrator(SearchTermsFinder searchTermsFinder) {
        this.searchTermsFinder = searchTermsFinder;
    }

    public List<SuggestedSearchTerm> getSearchTerms(SearchTermRequest searchTermRequest) {
        String searchTerm = searchTermRequest.getSearchTerm();

        return searchTermsFinder.findSearchTerms(searchTerm);
    }
}
