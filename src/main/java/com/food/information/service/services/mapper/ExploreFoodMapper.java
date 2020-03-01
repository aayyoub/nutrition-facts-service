package com.food.information.service.services.mapper;

import com.food.information.service.dataaccess.jpa.entity.ExploreFoodEntity;
import com.food.information.service.domain.model.ExploreFood;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ExploreFoodMapper {
    public List<ExploreFood> mapFoods(List<ExploreFoodEntity> topFoodEntities) {
        return topFoodEntities.stream()
                .map(exploreFoodEntity -> {
                    ExploreFood exploreFood = new ExploreFood();
                    exploreFood.setFoodId(exploreFoodEntity.getFoodDescriptionId());
                    exploreFood.setFoodDescription(exploreFoodEntity.getLongDescription());

                    return exploreFood;
                })
                .collect(toList());
    }
}
