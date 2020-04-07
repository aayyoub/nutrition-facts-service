package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MineralGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 2;
    private static final String GROUP_NAME = "minerals";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(
                NutrientId.CALCIUM,
                NutrientId.IRON,
                NutrientId.MAGNESIUM,
                NutrientId.PHOSPHORUS,
                NutrientId.POTASSIUM,
                NutrientId.SODIUM,
                NutrientId.ZINC,
                NutrientId.COPPER,
                NutrientId.MANGANESE,
                NutrientId.SELENIUM,
                NutrientId.FLUORIDE);
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
