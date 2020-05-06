package io.nutritionfacts.api.services;

import io.nutritionfacts.api.dataaccess.jpa.entity.FoodDescriptionEntity;
import io.nutritionfacts.api.dataaccess.jpa.repository.FoodRepository;
import io.nutritionfacts.api.domain.model.Food;
import io.nutritionfacts.api.services.mapper.FoodMapper;
import org.springframework.stereotype.Component;

@Component
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public Food getFood(String foodId) {
        FoodDescriptionEntity foodDescriptionEntity = foodRepository.getFood(foodId);

        return foodMapper.mapFood(foodDescriptionEntity);
    }
}
