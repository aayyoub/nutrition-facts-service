//package io.nutritionfacts.service.domain;
//
//import io.nutritionfacts.service.domain.formatter.SearchTermsFormatter;
//import io.nutritionfacts.service.domain.model.SuggestedSearchTerm;
//import io.nutritionfacts.service.services.SearchTermsService;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class SearchTermsFinder {
//    private final SearchTermsService searchTermsService;
//    private final SearchTermsFormatter searchTermsFormatter;
//
//    public SearchTermsFinder(SearchTermsService searchTermsService, SearchTermsFormatter searchTermsFormatter) {
//        this.searchTermsService = searchTermsService;
//        this.searchTermsFormatter = searchTermsFormatter;
//    }
//
//    public List<SuggestedSearchTerm> findSearchTerms(String searchTerm) {
//        List<SuggestedSearchTerm> searchTerms = searchTermsService.getSearchTerms(searchTerm);
//
//        return searchTermsFormatter.format(searchTerms);
//    }
//}
