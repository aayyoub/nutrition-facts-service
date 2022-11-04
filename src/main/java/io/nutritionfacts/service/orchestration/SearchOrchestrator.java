//package io.nutritionfacts.service.orchestration;
//
//import io.nutritionfacts.service.domain.SearchTermsFinder;
//import io.nutritionfacts.service.domain.model.SuggestedSearchTerm;
//import io.nutritionfacts.service.api.model.SearchTermRequest;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class SearchOrchestrator {
//    private final SearchTermsFinder searchTermsFinder;
//
//    public SearchOrchestrator(SearchTermsFinder searchTermsFinder) {
//        this.searchTermsFinder = searchTermsFinder;
//    }
//
//    public List<SuggestedSearchTerm> getSearchTerms(SearchTermRequest searchTermRequest) {
//        String searchTerm = searchTermRequest.getSearchTerm();
//
//        return searchTermsFinder.findSearchTerms(searchTerm);
//    }
//}
