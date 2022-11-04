package io.nutritionfacts.service.services.mapper;

import io.nutritionfacts.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import io.nutritionfacts.service.dataaccess.jpa.entity.NutrientDataEntity;
import io.nutritionfacts.service.dataaccess.jpa.entity.WeightEntity;
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
    public Food mapFood(FoodDescriptionEntity foodDescriptionEntity) {
        Food food = new Food();
        food.setId(foodDescriptionEntity.getFoodDescriptionId());
        food.setName(foodDescriptionEntity.getLongDescription());
        food.setServingSizes(buildServingSizes(foodDescriptionEntity.getWeightEntities()));
        food.setNutrients(foodDescriptionEntity.getNutrientDataEntities()
                                               .stream()
                                               .map(this::buildNutrient)
                                               .collect(Collectors.toMap(Nutrient::getId, Function.identity())));

        return food;
    }

    private Nutrient buildNutrient(NutrientDataEntity nutrientDataEntity) {
        Nutrient nutrient = new Nutrient();
        nutrient.setId(nutrientDataEntity.getNutrientNumber());
        nutrient.setValue(nutrientDataEntity.getNutrientValue());
        nutrient.setUnit(nutrientDataEntity.getNutrientDefinitionEntity().getUnits());
        nutrient.setRoundedToDecimal(Integer.valueOf(nutrientDataEntity.getNutrientDefinitionEntity().getRoundedToDecimal()));
        nutrient.setDescription(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientDescription());
        nutrient.setCommonName(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getCommonName());
        nutrient.setTagname(nutrientDataEntity.getNutrientDefinitionEntity().getTagname());
        nutrient.setDailyValue(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getNutrientDailyValue());
        nutrient.setSortOrder(nutrientDataEntity.getNutrientDefinitionEntity().getSortOrder());
        nutrient.setMacronutrient(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getMacronutrient());
        nutrient.setSubcomponent(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getSubcomponent());

        return nutrient;
    }

    private Set<ServingSize> buildServingSizes(Set<WeightEntity> weightEntities) {
        //default serving size is 100 grams for each food - not provided in weight table, so we add it manually
        WeightEntity oneHundredGramsWeightEntity = new WeightEntity();
        oneHundredGramsWeightEntity.setSequenceNumber("0");
        oneHundredGramsWeightEntity.setAmount(100.0);
        oneHundredGramsWeightEntity.setMeasurementDescription("grams");
        oneHundredGramsWeightEntity.setGramWeight(100.0);

        weightEntities.add(oneHundredGramsWeightEntity);

        return weightEntities.stream()
                             .map(this::buildServingSize)
                             .sorted(Comparator.comparing(ServingSize::getOrder))
                             .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private ServingSize buildServingSize(WeightEntity weightEntity) {
        ServingSize servingSize = new ServingSize();
        servingSize.setDescription(weightEntity.getAmount() + " " + weightEntity.getMeasurementDescription());
        servingSize.setGramWeight(weightEntity.getGramWeight());
        servingSize.setOrder(Integer.valueOf(weightEntity.getSequenceNumber()));

        return servingSize;
    }
}
