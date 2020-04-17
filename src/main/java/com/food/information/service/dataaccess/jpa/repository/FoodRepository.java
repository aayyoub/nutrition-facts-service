package com.food.information.service.dataaccess.jpa.repository;

import com.food.information.service.dataaccess.jpa.entity.ExploreFoodEntity;
import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.entity.FoodNameMappingEntity;
import com.food.information.service.dataaccess.jpa.entity.SearchTermEntity;

import java.util.List;

public interface FoodRepository {
    FoodDescriptionEntity getFood(String foodId);

    List<ExploreFoodEntity> getExploreFood();

    List<SearchTermEntity> getAllLinks();

    void save(FoodNameMappingEntity foodNameMappingEntity);

    FoodNameMappingEntity getFoodByName(String foodName);
}