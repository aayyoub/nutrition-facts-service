package io.nutritionfacts.api.dataaccess.jpa.repository;

import io.nutritionfacts.api.dataaccess.jpa.entity.ExploreFoodEntity;
import io.nutritionfacts.api.dataaccess.jpa.entity.FoodDescriptionEntity;
import io.nutritionfacts.api.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.api.dataaccess.jpa.entity.SearchTermEntity;

import java.util.List;

public interface FoodRepository {
    FoodDescriptionEntity getFood(String foodId);

    List<ExploreFoodEntity> getExploreFood();

    List<SearchTermEntity> getAllLinks();

    void save(FoodNameMappingEntity foodNameMappingEntity);

    FoodNameMappingEntity getFoodByName(String foodName);
}