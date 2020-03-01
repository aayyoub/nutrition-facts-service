package com.food.information.service.services;

import com.food.information.service.dataaccess.jpa.entity.ExploreFoodEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.model.ExploreFood;
import com.food.information.service.services.mapper.ExploreFoodMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExploreFoodService {
    private final FoodRepository foodRepository;
    private final ExploreFoodMapper exploreFoodMapper;

    public ExploreFoodService(FoodRepository foodRepository, ExploreFoodMapper exploreFoodMapper) {
        this.foodRepository = foodRepository;
        this.exploreFoodMapper = exploreFoodMapper;
    }

    public List<ExploreFood> getFood() {
        List<ExploreFoodEntity> topFoodEntities = foodRepository.getExploreFood();

        return exploreFoodMapper.mapFoods(topFoodEntities);
    }
}
