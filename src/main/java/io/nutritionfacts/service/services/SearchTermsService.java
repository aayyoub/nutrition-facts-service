package io.nutritionfacts.service.services;

import io.nutritionfacts.service.dataaccess.elasticsearch.entity.SearchTermEntity;
import io.nutritionfacts.service.dataaccess.elasticsearch.repository.SearchTermRepository;
import io.nutritionfacts.service.domain.model.SuggestedSearchTerm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchTermsService {
    private final SearchTermRepository searchTermRepository;

    public SearchTermsService(SearchTermRepository searchTermRepository) {
        this.searchTermRepository = searchTermRepository;
    }

    public List<SuggestedSearchTerm> getSearchTerms(String foodName) {
        Page<SearchTermEntity> searchTermEntityList = searchTermRepository.findTop35BySearchTerm(foodName, PageRequest.of(0, 35));

        return searchTermEntityList
                .getContent()
                .stream()
                .sorted(Comparator.comparing(SearchTermEntity::getId))
                .map(this::buildSuggestedSearchTerm)
                .collect(Collectors.toList());
    }

    private SuggestedSearchTerm buildSuggestedSearchTerm(SearchTermEntity searchTermEntity) {
        SuggestedSearchTerm suggestedSearchTerm = new SuggestedSearchTerm();
        suggestedSearchTerm.setId(searchTermEntity.getId());
        suggestedSearchTerm.setSearchTerm(searchTermEntity.getSearchTerm().toLowerCase());

        return suggestedSearchTerm;
    }
}
