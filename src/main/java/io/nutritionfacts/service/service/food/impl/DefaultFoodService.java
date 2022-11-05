package io.nutritionfacts.service.service.food.impl;

import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodDescription;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.FoodRepository;
import io.nutritionfacts.service.domain.model.FoodId;
import io.nutritionfacts.service.domain.model.FoodSummary;
import io.nutritionfacts.service.service.food.FoodService;
import io.nutritionfacts.service.service.food.impl.mapper.FoodMapper;
import org.springframework.stereotype.Component;

@Component
public class DefaultFoodService implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public DefaultFoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public FoodSummary getFood(FoodId foodId) {
        FoodDescription foodDescription = foodRepository.getFood(foodId.getId());

        return foodMapper.mapFood(foodDescription);
    }
}
