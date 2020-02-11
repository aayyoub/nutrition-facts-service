package com.food.information.service.api.controller;

import com.food.information.service.api.model.Response;
import com.food.information.service.domain.model.SuggestedSearchTerm;
import com.food.information.service.orchestration.SearchOrchestrator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private final SearchOrchestrator searchOrchestrator;

    public SearchController(SearchOrchestrator searchOrchestrator) {
        this.searchOrchestrator = searchOrchestrator;
    }

    @CrossOrigin
    @GetMapping("/search")
    public List<SuggestedSearchTerm> searchFood(@RequestParam String searchTerm) {
        return searchOrchestrator.getSearchTerms(searchTerm);
    }
}
