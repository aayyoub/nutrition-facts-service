//package io.nutritionfacts.service.api.controller;
//
//import io.nutritionfacts.service.domain.model.SuggestedSearchTerm;
//import io.nutritionfacts.service.orchestration.SearchOrchestrator;
//import io.nutritionfacts.service.api.model.Response;
//import io.nutritionfacts.service.api.model.SearchTermRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//public class SearchController {
//    private final SearchOrchestrator searchOrchestrator;
//
//    public SearchController(SearchOrchestrator searchOrchestrator) {
//        this.searchOrchestrator = searchOrchestrator;
//    }
//
//    @CrossOrigin
//    @GetMapping("/search/{searchTerm}")
//    public Response<List<SuggestedSearchTerm>> searchFood(@Valid SearchTermRequest searchTermRequest) {
//        List<SuggestedSearchTerm> searchTerms = searchOrchestrator.getSearchTerms(searchTermRequest);
//
//        Response<List<SuggestedSearchTerm>> response = new Response<>();
//        response.setHttpStatus(HttpStatus.OK);
//        response.setRequestId(searchTermRequest.getRequestId());
//        response.setResult(searchTerms);
//
//        return response;
//    }
//}
