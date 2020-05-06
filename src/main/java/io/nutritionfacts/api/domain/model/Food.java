package io.nutritionfacts.api.domain.model;

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
    private String id;
    private String name;
    private String description;
    private String calories;
    private ServingSize selectedServingSize;
    private Set<ServingSize> servingSizes;
    private NutritionFacts nutritionFacts;
    private CaloricPyramid caloricPyramid;
    private List<NutrientGroup> nutrientGroups;
    private SeoTags seoTags;
    @JsonIgnore
    private Map<String, Nutrient> nutrients;
    @JsonIgnore
    private Map<String, Nutrient> nutrientsPerServingSize;
}