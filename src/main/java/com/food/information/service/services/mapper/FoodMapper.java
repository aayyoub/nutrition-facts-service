package com.food.information.service.services.mapper;

import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.entity.NutrientDataEntity;
import com.food.information.service.domain.formatter.DecimalFormatter;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.Nutrient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FoodMapper {
    public Food mapFood(FoodDescriptionEntity foodDescriptionEntity) {
        Food food = new Food();
        food.setFoodId(foodDescriptionEntity.getFoodDescriptionId());
        food.setShortDescription(foodDescriptionEntity.getShortDescription());
        food.setLongDescription(foodDescriptionEntity.getLongDescription());

        Map<String, Nutrient> nutrients = foodDescriptionEntity.getNutrientDatumEntities()
                .stream()
                .map(this::buildNutrient)
                .collect(Collectors.toMap(Nutrient::getId, Function.identity()));

        food.setNutrients(nutrients);

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

        return nutrient;
    }
}
