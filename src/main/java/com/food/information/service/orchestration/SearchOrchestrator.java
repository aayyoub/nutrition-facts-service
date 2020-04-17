package com.food.information.service.orchestration;

import com.food.information.service.api.model.SearchTermRequest;
import com.food.information.service.domain.SearchTermsFinder;
import com.food.information.service.domain.model.SuggestedSearchTerm;
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
