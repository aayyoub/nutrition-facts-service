package com.food.information.service.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private String foodId;
    private String shortDescription;
    private String longDescription;
    private Map<String, Nutrient> nutrients;
    private Set<ServingSize> servingSizes;
}