package com.food.information.service.services;

import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.model.Food;
import com.food.information.service.services.mapper.FoodMapper;
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
