package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OverviewGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 1;
    private static final String GROUP_NAME = "overview";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList("WATER", "ENERC_KCAL", "ENERC_KJ", "ASH", "PROCNT", "FAT", "CHOCDF", "FIBTG", "SUGAR");
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
