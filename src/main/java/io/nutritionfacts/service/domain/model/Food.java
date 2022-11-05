package io.nutritionfacts.service.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Food {
    private FoodId id;
    private String name;
    private String description;
    private Set<ServingSize> servingSizes;
    private Nutrients nutrients;
    private ServingSize selectedServingSize;
    private String calories;
    private NutritionFacts nutritionFacts;
    private CaloricPyramid caloricPyramid;
    private List<NutrientGroup> nutrientGroups;
    private String disclaimer;
}
