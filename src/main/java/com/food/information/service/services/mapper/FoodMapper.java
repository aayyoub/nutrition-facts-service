package com.food.information.service.services.mapper;

import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.domain.formatter.DecimalFormatter;
import com.food.information.service.domain.model.Food;
import com.food.information.service.domain.model.Nutrient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FoodMapper {
    private final DecimalFormatter decimalFormatter;

    public FoodMapper(DecimalFormatter decimalFormatter) {
        this.decimalFormatter = decimalFormatter;
    }

    public Food mapFood(FoodDescriptionEntity foodDescriptionEntity) {
        Food food = new Food();
        food.setFoodId(foodDescriptionEntity.getFoodDescriptionId());
        food.setShortDescription(foodDescriptionEntity.getShortDescription());
        food.setLongDescription(foodDescriptionEntity.getLongDescription());

        Map<String, Nutrient> nutrients = foodDescriptionEntity.getNutrientDatumEntities()
                .stream()
                .map(nutrientData -> {
                    Nutrient nutrient = new Nutrient();
                    nutrient.setId(nutrientData.getNutrientNumber());
                    nutrient.setValue(nutrientData.getNutrientValue());
                    nutrient.setUnit(nutrientData.getNutrientDefinitionEntity().getUnits());
                    nutrient.setRoundedToDecimal(Integer.valueOf(nutrientData.getNutrientDefinitionEntity().getRoundedToDecimal()));
                    nutrient.setDescription(nutrientData.getNutrientDefinitionEntity().getNutrientDescription());
                    nutrient.setTagname(nutrientData.getNutrientDefinitionEntity().getTagname());
                    nutrient.setDailyValue(nutrientData.getNutrientDefinitionEntity().getNutrientDailyValue());
                    nutrient.setSortOrder(nutrientData.getNutrientDefinitionEntity().getSortOrder());

                    return nutrient;
                })
                .collect(Collectors.toMap(Nutrient::getId, Function.identity()));

        food.setNutrients(nutrients);

        return food;
    }
}
