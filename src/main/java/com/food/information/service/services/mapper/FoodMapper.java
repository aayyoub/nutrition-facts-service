package com.food.information.service.services.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.entity.NutrientDataEntity;
import com.food.information.service.dataaccess.jpa.entity.WeightEntity;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.ServingSize;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FoodMapper {
    private final ObjectMapper mapper = new ObjectMapper();

    public Food mapFood(FoodDescriptionEntity foodDescriptionEntity) {
        Food food = new Food();
        food.setId(foodDescriptionEntity.getFoodDescriptionId());
        food.setName(foodDescriptionEntity.getLongDescription());
        food.setServingSizes(foodDescriptionEntity.getWeightEntities()
                .stream()
                .map(this::buildServingSize)
                .sorted(Comparator.comparing(ServingSize::getOrder))
                .collect(Collectors.toCollection(LinkedHashSet::new)));
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
        nutrient.setExternalLink(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getExternalLink());
        nutrient.setMacronutrient(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getMacronutrient());
        nutrient.setSubcomponent(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getSubcomponent());

        try {
            nutrient.setGoodFor(mapper.readTree(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getGoodFor()));
            nutrient.setBadFor(mapper.readTree(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getBadFor()));
        } catch (Exception ignored) {
        }

        nutrient.setIsBeneficial(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getBeneficial());
        nutrient.setTargetLessThanValue(Optional.ofNullable(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getTargetLessThanValue()));
        nutrient.setTargetMoreThanValue(Optional.ofNullable(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getTargetMoreThanValue()));
        nutrient.setTargetLessThanDailyValue(Optional.ofNullable(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getTargetLessThanDailyValue()));
        nutrient.setTargetMoreThanDailyValue(Optional.ofNullable(nutrientDataEntity.getNutrientDefinitionEntity().getNutrientExtraInformationEntity().getTargetMoreThanDailyValue()));

        return nutrient;
    }

    private ServingSize buildServingSize(WeightEntity weightEntity) {
        ServingSize servingSize = new ServingSize();
        servingSize.setDescription(weightEntity.getAmount() + " " + weightEntity.getMeasurementDescription());
        servingSize.setGramWeight(weightEntity.getGramWeight());
        servingSize.setOrder(Integer.valueOf(weightEntity.getSequenceNumber()));

        return servingSize;
    }
}
