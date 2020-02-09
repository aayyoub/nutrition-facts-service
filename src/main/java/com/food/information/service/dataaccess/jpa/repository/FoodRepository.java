package com.food.information.service.dataaccess.jpa.repository;

import com.food.information.service.dataaccess.jpa.entity.FoodDescription;
import com.food.information.service.dataaccess.jpa.entity.SearchTerm;

import java.util.List;

public interface FoodRepository {
    FoodDescription getFood(String foodId);

    List<SearchTerm> getSearchTerms(String searchTerm);
}