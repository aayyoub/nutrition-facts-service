package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OtherGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 7;
    private static final String GROUP_NAME = "other";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(
                NutrientId.WATER,
                NutrientId.ASH,
                NutrientId.ALCOHOL,
                NutrientId.CAFFEINE,
                NutrientId.THEOBROMINE);
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
