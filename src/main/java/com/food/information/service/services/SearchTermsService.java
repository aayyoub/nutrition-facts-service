package com.food.information.service.services;

import com.food.information.service.dataaccess.jpa.entity.SearchTermEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.model.SuggestedSearchTerm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchTermsService {
    private final FoodRepository foodRepository;

    public SearchTermsService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<SuggestedSearchTerm> getSearchTerms(String foodName) {
        List<SearchTermEntity> searchTermEntityList = foodRepository.getSearchTerms(foodName);

        return searchTermEntityList
                .stream()
                .map(this::buildSuggestedSearchTerm)
                .collect(Collectors.toList());
    }

    private SuggestedSearchTerm buildSuggestedSearchTerm(SearchTermEntity searchTermEntity) {
        SuggestedSearchTerm suggestedSearchTerm = new SuggestedSearchTerm();
        suggestedSearchTerm.setSearchTerm(searchTermEntity.getLongDescription().toLowerCase());
        suggestedSearchTerm.setValue(searchTermEntity.getFoodDescriptionId());

        return suggestedSearchTerm;
    }
}
