package com.food.information.service.services.mapper;

import com.food.information.service.dataaccess.jpa.entity.FoodDescription;
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

    public Food mapFood(FoodDescription foodDescription) {
        Food food = new Food();
        food.setFoodId(foodDescription.getFoodDescriptionId());
        food.setShortDescription(foodDescription.getShortDescription());
        food.setLongDescription(foodDescription.getLongDescription());

        Map<String, Nutrient> nutrients = foodDescription.getNutrientData()
                .stream()
                .map(nutrientData -> {
                    Nutrient nutrient = new Nutrient();
                    nutrient.setId(nutrientData.getNutrientNumber());
                    nutrient.setValue(nutrientData.getNutrientValue());
                    nutrient.setUnit(nutrientData.getNutrientDefinition().getUnits());
                    nutrient.setRoundedToDecimal(Integer.valueOf(nutrientData.getNutrientDefinition().getRoundedToDecimal()));
                    nutrient.setDescription(nutrientData.getNutrientDefinition().getNutrientDescription());
                    nutrient.setTagname(nutrientData.getNutrientDefinition().getTagname());
                    nutrient.setDailyValue(nutrientData.getNutrientDefinition().getNutrientDailyValue());
                    nutrient.setSortOrder(nutrientData.getNutrientDefinition().getSortOrder());

                    return nutrient;
                })
                .collect(Collectors.toMap(Nutrient::getId, Function.identity()));

        food.setNutrients(nutrients);

        return food;
    }
}
