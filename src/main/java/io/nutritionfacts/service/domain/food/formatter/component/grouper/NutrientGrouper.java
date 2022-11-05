package io.nutritionfacts.service.domain.food.formatter.component.grouper;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;
import io.nutritionfacts.service.domain.model.Nutrients;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NutrientGrouper {
  private final List<Group> groups;

  public NutrientGrouper(List<Group> groups) {
    this.groups = groups;
  }

  public List<NutrientGroup> group(Nutrients nutrients) {
    return groups
        .stream()
        .map(group -> map(group, nutrients))
        .sorted(Comparator.comparingInt(NutrientGroup::getRank))
        .collect(Collectors.toList());
  }

  public NutrientGroup map(Group group, Nutrients nutrients) {
    List<Nutrient> filteredNutrients = nutrients.nutrients.values()
        .stream()
        .filter(nutrient -> group.getNutrients().contains(nutrient.getId()))
        .sorted(Comparator.comparingInt(Nutrient::getSortOrder))
        .collect(Collectors.toList());

    return new NutrientGroup(group.getRank(), group.getName(), filteredNutrients);
  }
}
