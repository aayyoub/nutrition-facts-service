package io.nutritionfacts.service.service.food.impl.mapper;

import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodDescription;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.NutrientData;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.Weight;
import io.nutritionfacts.service.domain.model.Food;
import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FoodMapper {
    public Food mapFood(FoodDescription foodDescription) {
        Food food = new Food();
        food.setId(foodDescription.getFoodDescriptionId());
        food.setName(foodDescription.getLongDescription());
        food.setServingSizes(buildServingSizes(foodDescription.getWeightEntities()));
        food.setNutrients(foodDescription.getNutrientDataEntities()
                                               .stream()
                                               .map(this::buildNutrient)
                                               .collect(Collectors.toMap(Nutrient::getId, Function.identity())));

        return food;
    }

    private Nutrient buildNutrient(NutrientData nutrientData) {
        Nutrient nutrient = new Nutrient();
        nutrient.setId(nutrientData.getNutrientNumber());
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
        //default serving size is 100 grams for each food - not provided in weight table, so we add it manually
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
