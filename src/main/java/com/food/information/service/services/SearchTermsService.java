package com.food.information.service.services;

import com.food.information.service.dataaccess.elasticsearch.entity.SearchTermEntity;
import com.food.information.service.dataaccess.elasticsearch.repository.SearchTermRepository;
import com.food.information.service.domain.model.SuggestedSearchTerm;
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
        Page<SearchTermEntity> searchTermEntityList = searchTermRepository.findTop25BySearchTerm(foodName, PageRequest.of(0, 25));

        return searchTermEntityList
                .getContent()
                .stream()
                .sorted(Comparator.comparing(SearchTermEntity::getId))
                .map(this::buildSuggestedSearchTerm)
                .collect(Collectors.toList());
    }

    private SuggestedSearchTerm buildSuggestedSearchTerm(SearchTermEntity searchTermEntity) {
        SuggestedSearchTerm suggestedSearchTerm = new SuggestedSearchTerm();
        suggestedSearchTerm.setSearchTerm(searchTermEntity.getSearchTerm().toLowerCase());
        suggestedSearchTerm.setValue(searchTermEntity.getId());

        return suggestedSearchTerm;
    }
}
