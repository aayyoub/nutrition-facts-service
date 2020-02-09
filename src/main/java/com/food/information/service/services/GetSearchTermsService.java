package com.food.information.service.services;

import com.food.information.service.dataaccess.jpa.entity.SearchTerm;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.model.SuggestedSearchTerm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchTermsService {
    private final FoodRepository foodRepository;

    public GetSearchTermsService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<SuggestedSearchTerm> getSearchTerms(String foodName) {
        List<SearchTerm> searchTermList = foodRepository.getSearchTerms(foodName);

        return searchTermList
                .stream()
                .map(this::buildSuggestedSearchTerm)
                .collect(Collectors.toList());
    }

    private SuggestedSearchTerm buildSuggestedSearchTerm(SearchTerm searchTerm) {
        SuggestedSearchTerm suggestedSearchTerm = new SuggestedSearchTerm();
        suggestedSearchTerm.setSearchTerm(searchTerm.getLongDescription().toLowerCase());
        suggestedSearchTerm.setValue(searchTerm.getFoodDescriptionId());

        return suggestedSearchTerm;
    }
}
