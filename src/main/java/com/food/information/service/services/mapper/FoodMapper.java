package com.food.information.service.services.mapper;

import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.entity.NutrientDataEntity;
import com.food.information.service.dataaccess.jpa.entity.WeightEntity;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Component
public class FoodMapper {
    public Food mapFood(FoodDescriptionEntity foodDescriptionEntity) {
        Food food = new Food();
        food.setFoodId(foodDescriptionEntity.getFoodDescriptionId());
        food.setShortDescription(foodDescriptionEntity.getShortDescription());
        food.setLongDescription(foodDescriptionEntity.getLongDescription());
        food.setServingSizes(foodDescriptionEntity.getWeightEntities()
                .stream()
                .map(this::buildServingSize)
                .collect(toSet()));
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
        nutrient.setTagname(nutrientDataEntity.getNutrientDefinitionEntity().getTagname());
        nutrient.setDailyValue(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getNutrientDailyValue());
        nutrient.setSortOrder(nutrientDataEntity.getNutrientDefinitionEntity().getSortOrder());
        nutrient.setDisplayTop(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getDisplayTop());

        return nutrient;
    }

    private ServingSize buildServingSize(WeightEntity weightEntity) {
        ServingSize servingSize = new ServingSize();
        servingSize.setDescription(weightEntity.getAmount() + " " + weightEntity.getMeasurementDescription());
        servingSize.setGramWeight(weightEntity.getGramWeight());
        servingSize.setOrder(weightEntity.getSequenceNumber());

        return servingSize;
    }
}
