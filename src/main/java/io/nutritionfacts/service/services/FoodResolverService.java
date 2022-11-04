package io.nutritionfacts.service.services;

import io.nutritionfacts.service.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.service.dataaccess.jpa.repository.FoodRepository;
import org.springframework.stereotype.Component;

@Component
public class FoodResolverService {
    private final FoodRepository foodRepository;

    public FoodResolverService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public String resolveFood(String foodName) {
        FoodNameMappingEntity foodNameMappingEntity = foodRepository.getFoodIdByName(foodName);

        return foodNameMappingEntity.getFoodId();
    }
}
