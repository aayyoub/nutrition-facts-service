package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CarbohydrateGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 4;
    private static final String GROUP_NAME = "carbohydrates";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(
                NutrientId.CARBOHYDRATE,
                NutrientId.FIBER,
                NutrientId.STARCH,
                NutrientId.TOTAL_SUGAR,
                NutrientId.SUCROSE,
                NutrientId.GLUCOSE,
                NutrientId.FRUCTOSE,
                NutrientId.LACTOSE,
                NutrientId.MALTOSE,
                NutrientId.GALACTOSE
        );
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
