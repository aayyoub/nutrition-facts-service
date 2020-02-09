package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MineralGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 3;
    private static final String GROUP_NAME = "minerals";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList("CA", "FE", "MG", "P", "K", "NA", "ZN", "CU", "MN", "SE", "FLD");
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
