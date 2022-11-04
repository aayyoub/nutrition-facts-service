package io.nutritionfacts.service.service.food.impl;

import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodDescription;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.FoodRepository;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodNameMapping;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;
import io.nutritionfacts.service.service.food.IFoodService;
import io.nutritionfacts.service.service.food.impl.mapper.FoodMapper;
import org.springframework.stereotype.Component;

@Component
public class FoodService implements IFoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public FoodId getFoodId(String name) {
        FoodNameMapping foodNameMapping = foodRepository.getFoodId(name);

        return new FoodId(foodNameMapping.getFoodId());
    }

    public Food getFood(FoodId foodId) {
        FoodDescription foodDescription = foodRepository.getFood(foodId.getId());

        return foodMapper.mapFood(foodDescription);
    }
}
