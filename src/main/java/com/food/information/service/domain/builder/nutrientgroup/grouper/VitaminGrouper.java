package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VitaminGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 1;
    private static final String GROUP_NAME = "vitamins";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(NutrientId.VITAMIN_A_IU, NutrientId.VITAMIN_A_RAE, NutrientId.VITAMIN_C,
                NutrientId.VITAMIN_D, NutrientId.VITAMIN_E, NutrientId.VITAMIN_K, NutrientId.THIAMIN,
                NutrientId.RIBOFLAVIN, NutrientId.NIACIN, NutrientId.VITAMIN_B6, NutrientId.FOLIC_ACID,
                NutrientId.FOLATE_TOTAL, NutrientId.VITAMIN_B12, NutrientId.PANTOTHENIC_ACID, NutrientId.CHOLINE_TOTAL,
                NutrientId.BETAINE);
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
