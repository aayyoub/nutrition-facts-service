package io.nutritionfacts.api.api.controller;

import io.nutritionfacts.api.api.model.SearchTermRequest;
import io.nutritionfacts.api.domain.model.SuggestedSearchTerm;
import io.nutritionfacts.api.orchestration.SearchOrchestrator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private final SearchOrchestrator searchOrchestrator;

    public SearchController(SearchOrchestrator searchOrchestrator) {
        this.searchOrchestrator = searchOrchestrator;
    }

    @CrossOrigin
    @GetMapping("/search/{searchTerm}")
    public List<SuggestedSearchTerm> searchFood(SearchTermRequest searchTermRequest) {
        return searchOrchestrator.getSearchTerms(searchTermRequest);
    }
}
