package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import com.food.information.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SterolGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 6;
    private static final String GROUP_NAME = "sterols";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(NutrientId.CHOLESTEROL, NutrientId.PHYTOSTEROLS);
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
