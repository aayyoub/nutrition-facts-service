package io.nutritionfacts.service.domain.food.formatter.component.grouper;

import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Grouper {
  private final List<Group> groups;

  public Grouper(List<Group> groups) {
    this.groups = groups;
  }

  public List<NutrientGroup> group(Map<String, Nutrient> nutrients) {
    return groups
        .stream()
        .map(group -> map(group, nutrients))
        .sorted(Comparator.comparingInt(NutrientGroup::getRank))
        .collect(Collectors.toList());
  }

  public NutrientGroup map(Group group, Map<String, Nutrient> nutrients) {
    List<Nutrient> filteredNutrients = nutrients.values()
        .stream()
        .filter(nutrient -> group.getNutrients().contains(nutrient.getId()))
        .sorted(Comparator.comparingInt(Nutrient::getSortOrder))
        .collect(Collectors.toList());

    return new NutrientGroup(group.getRank(), group.getName(), filteredNutrients);
  }
}
