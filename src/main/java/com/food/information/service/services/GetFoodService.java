package com.food.information.service.services;

import com.food.information.service.dataaccess.jpa.entity.FoodDescription;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.model.Food;
import com.food.information.service.services.mapper.FoodMapper;
import org.springframework.stereotype.Component;

@Component
public class GetFoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public GetFoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public Food getFood(String foodId) {
        FoodDescription foodDescription = foodRepository.getFood(foodId);

        return foodMapper.mapFood(foodDescription);
    }
}
