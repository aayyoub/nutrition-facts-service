package com.food.information.service.dataaccess.jpa.repository;

import com.food.information.service.dataaccess.jpa.entity.ExploreFoodEntity;
import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.entity.SearchTermEntity;

import java.util.List;

public interface FoodRepository {
    FoodDescriptionEntity getFood(String foodId);

    List<SearchTermEntity> getSearchTerms(String searchTerm);

    List<ExploreFoodEntity> getExploreFood();
}