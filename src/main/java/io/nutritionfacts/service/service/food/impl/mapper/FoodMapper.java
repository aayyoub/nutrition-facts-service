package io.nutritionfacts.service.service.food.impl.mapper;

import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodDescription;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.NutrientData;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.Weight;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.FoodId;
import io.nutritionfacts.service.domain.model.FoodSummary;
import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientId;
import io.nutritionfacts.service.domain.model.Nutrients;
import io.nutritionfacts.service.domain.model.ServingSize;
import java.util.function.Function;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FoodMapper {
  public FoodSummary mapFood(FoodDescription foodDescription) {
    FoodSummary foodSummary = new FoodSummary();
    foodSummary.setId(new FoodId(foodDescription.getFoodDescriptionId()));
    foodSummary.setName(foodDescription.getLongDescription());
    foodSummary.setServingSizes(buildServingSizes(foodDescription.getWeightEntities()));
    foodSummary.setNutrients(buildNutrients(foodDescription.getNutrientDataEntities()));

    return foodSummary;
  }

  public Nutrients buildNutrients(Set<NutrientData> nutrientData) {
    var nutrients = nutrientData
        .stream()
        .map(this::buildNutrient)
        .collect(Collectors.toMap(Nutrient::getId, Function.identity()));

    return new Nutrients(nutrients);
  }

  private Nutrient buildNutrient(NutrientData nutrientData) {
    Nutrient nutrient = new Nutrient();
    nutrient.setId(NutrientId.of(nutrientData.getNutrientNumber()));
    nutrient.setValue(nutrientData.getNutrientValue());
    nutrient.setUnit(nutrientData.getNutrientDefinitionEntity().getUnits());
    nutrient.setRoundedToDecimal(Integer.valueOf(nutrientData.getNutrientDefinitionEntity().getRoundedToDecimal()));
    nutrient.setDescription(nutrientData.getNutrientDefinitionEntity().getNutrientDescription());
    nutrient.setCommonName(nutrientData.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getCommonName());
    nutrient.setTagname(nutrientData.getNutrientDefinitionEntity().getTagname());
    nutrient.setDailyValue(nutrientData.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getNutrientDailyValue());
    nutrient.setSortOrder(nutrientData.getNutrientDefinitionEntity().getSortOrder());
    nutrient.setMacronutrient(nutrientData.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getMacronutrient());
    nutrient.setSubcomponent(nutrientData.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getSubcomponent());

    return nutrient;
  }

  private Set<ServingSize> buildServingSizes(Set<Weight> weightEntities) {
    //default serving size is 100 grams for each food - since this is not provided, we add it here
    Weight oneHundredGramsWeight = new Weight();
    oneHundredGramsWeight.setSequenceNumber("0");
    oneHundredGramsWeight.setAmount(100.0);
    oneHundredGramsWeight.setMeasurementDescription("grams");
    oneHundredGramsWeight.setGramWeight(100.0);

    weightEntities.add(oneHundredGramsWeight);

    return weightEntities.stream()
        .map(this::buildServingSize)
        .sorted(Comparator.comparing(ServingSize::getOrder))
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  private ServingSize buildServingSize(Weight weight) {
    ServingSize servingSize = new ServingSize();
    servingSize.setDescription(weight.getAmount() + " " + weight.getMeasurementDescription());
    servingSize.setGramWeight(weight.getGramWeight());
    servingSize.setOrder(Integer.valueOf(weight.getSequenceNumber()));

    return servingSize;
  }
}
