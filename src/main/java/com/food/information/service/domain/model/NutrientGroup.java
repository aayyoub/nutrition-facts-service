package com.food.information.service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NutrientGroup {
    private Integer rank;
    private String groupName;
    private List<Nutrient> nutrients;
}
