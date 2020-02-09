package com.food.information.service.orchestration;

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

    public List<SuggestedSearchTerm> getSearchTerms(String searchTerm) {
        return searchTermsFinder.findSearchTerms(searchTerm);
    }
}
