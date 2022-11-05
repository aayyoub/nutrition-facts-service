package io.nutritionfacts.service.domain.food.formatter.component.grouper.nutrient;

import io.nutritionfacts.service.domain.food.formatter.component.NutrientId;
import io.nutritionfacts.service.domain.food.formatter.component.grouper.Group;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Protein implements Group {
  public String getName() {
    return "Protein and Amino Acids";
  }

  public Integer getRank() {
    return 1;
  }

  public List<String> getNutrients() {
    return Arrays.asList(
        NutrientId.TOTAL_PROTEIN,
        NutrientId.ALANINE,
        NutrientId.ARGININE,
        NutrientId.ASPARTIC_ACID,
        NutrientId.CYSTINE,
        NutrientId.GLUTAMIC_ACID,
        NutrientId.GLYCINE,
        NutrientId.HISTIDINE,
        NutrientId.ISOLEUCINE,
        NutrientId.LEUCINE,
        NutrientId.LYSINE,
        NutrientId.METHIONINE,
        NutrientId.PHENYLALANINE,
        NutrientId.PROLINE,
        NutrientId.SERINE,
        NutrientId.THREONINE,
        NutrientId.TRYPTOPHAN,
        NutrientId.TYROSINE,
        NutrientId.VALINE,
        NutrientId.HYDROXYPROLINE);
  }
}
