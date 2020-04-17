package com.food.information.service.services;

import com.food.information.service.dataaccess.jpa.entity.FoodNameMappingEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import org.springframework.stereotype.Component;

@Component
public class FoodResolverService {
    private final FoodRepository foodRepository;

    public FoodResolverService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public String resolveFood(String foodName) {
        FoodNameMappingEntity foodNameMappingEntity = foodRepository.getFoodByName(foodName);

        return foodNameMappingEntity.getFoodId();
    }
}
