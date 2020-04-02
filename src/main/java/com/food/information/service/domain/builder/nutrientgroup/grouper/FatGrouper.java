package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FatGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 5;
    private static final String GROUP_NAME = "fat";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(NutrientId.TOTAL_FAT, NutrientId.TOTAL_SATURATED_FATTY_ACIDS, NutrientId.TOTAL_MONOUNSATURATED_FATTY_ACIDS,
                NutrientId.TOTAL_POLYUNSATURATED_FATTY_ACIDS, NutrientId.TOTAL_TRANS_FATTY_ACIDS, NutrientId.TOTAL_TRANSMONOENOIC_FATTY_ACIDS,
                NutrientId.TOTAL_TRANSPOLYENOIC_FATTY_ACIDS);
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
