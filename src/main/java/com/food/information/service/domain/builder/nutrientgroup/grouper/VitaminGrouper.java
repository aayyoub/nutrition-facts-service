package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.exception.NutrientNotFoundException;
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
        return Arrays.asList(
                NutrientId.VITAMIN_C,
                NutrientId.THIAMIN,
                NutrientId.RIBOFLAVIN,
                NutrientId.NIACIN,
                NutrientId.PANTOTHENIC_ACID,
                NutrientId.VITAMIN_B6,
                NutrientId.FOLATE_TOTAL,
                NutrientId.FOLIC_ACID,
                NutrientId.FOLATE_FOOD,
                NutrientId.FOLATE_DFE,
                NutrientId.CHOLINE_TOTAL,
                NutrientId.BETAINE,
                NutrientId.VITAMIN_B12,
                NutrientId.VITAMIN_B12_ADDED,
                NutrientId.VITAMIN_A_RAE,
                NutrientId.RETINOL,
                NutrientId.CAROTENE_BETA,
                NutrientId.CAROTENE_ALPHA,
                NutrientId.CRYPTOXANTHIN_BETA,
                NutrientId.VITAMIN_A_IU,
                NutrientId.LYCOPENE,
                NutrientId.LUTEIN_AND_ZEAXANTHIN,
                NutrientId.VITAMIN_E,
                NutrientId.VITAMIN_E_ADDED,
                NutrientId.TOCOPHEROL_BETA,
                NutrientId.TOCOPHEROL_GAMMA,
                NutrientId.TOCOPHEROL_DELTA,
                NutrientId.TOCOTRIENOL_ALPHA,
                NutrientId.TOCOTRIENOL_BETA,
                NutrientId.TOCOTRIENOL_GAMMA,
                NutrientId.TOCOTRIENOL_DELTA,
                NutrientId.VITAMIN_D_D2_AND_D3,
                NutrientId.VITAMIN_D2,
                NutrientId.VITAMIN_D3,
                NutrientId.VITAMIN_D,
                NutrientId.VITAMIN_K,
                NutrientId.DIHYDROPHYLLOQUINONE,
                NutrientId.MENAQUINONE4);
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
