package io.nutritionfacts.service.domain.model;

import java.util.Set;
import lombok.Data;

@Data
public class FoodSummary {
  private FoodId id;
  private String name;
  private String description;
  private Set<ServingSize> servingSizes;
  private Nutrients nutrients;
}
