package com.food.information.service.api.controller.dev;

import com.food.information.service.dataaccess.elasticsearch.entity.SearchTermEntity;
import com.food.information.service.dataaccess.elasticsearch.repository.SearchTermRepository;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {
    private final FoodRepository foodRepository;
    private final SearchTermRepository searchTermRepository;

    public DevController(FoodRepository foodRepository, SearchTermRepository searchTermRepository) {
        this.foodRepository = foodRepository;
        this.searchTermRepository = searchTermRepository;
    }

    @CrossOrigin
    @GetMapping("/buildSearchIndex")
    public void buildSearchIndex() {
        foodRepository.getAllLinks().forEach((searchTerm) -> {
                    SearchTermEntity searchTermEntity = new SearchTermEntity();
                    searchTermEntity.setId(searchTerm.getFoodDescriptionId());
                    searchTermEntity.setSearchTerm(searchTerm.getLongDescription());
                    searchTermRepository.save(searchTermEntity);
                }
        );
    }
}
