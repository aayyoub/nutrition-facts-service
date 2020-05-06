package io.nutritionfacts.api.services;

import io.nutritionfacts.api.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.api.dataaccess.jpa.repository.FoodRepository;
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
