package io.nutritionfacts.service.dataaccess.jpa.repository;

import io.nutritionfacts.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import io.nutritionfacts.service.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.service.dataaccess.jpa.entity.SearchTermEntity;

import java.util.List;

public interface FoodRepository {
    FoodNameMappingEntity getFoodIdByName(String foodName);

    FoodDescriptionEntity getFood(String foodId);

    List<SearchTermEntity> getAllLinks();

    void save(FoodNameMappingEntity foodNameMappingEntity);
}
