package com.food.information.service.api.controller;

import com.food.information.service.domain.model.ExploreFood;
import com.food.information.service.orchestration.ExploreFoodOrchestrator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExploreFoodController {
    private final ExploreFoodOrchestrator exploreFoodOrchestrator;

    public ExploreFoodController(ExploreFoodOrchestrator exploreFoodOrchestrator) {
        this.exploreFoodOrchestrator = exploreFoodOrchestrator;
    }

    @CrossOrigin
    @GetMapping("/explore")
    public List<ExploreFood> getExploreFood() {
        return exploreFoodOrchestrator.getFood();
    }
}
