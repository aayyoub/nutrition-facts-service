package com.food.information.service.domain.builder.nutrientgroup.grouper;

import com.food.information.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VitaminGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 2;
    private static final String GROUP_NAME = "vitamins";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList("VITA_IU", "VITA_RAE", "VITC", "VITD", "TOCPHA", "VITK1", "THIA", "RIBF", "NIA",
                "VITB6A", "FOLAC", "FOL", "VITB12", "PANTAC", "CHOLN", "BETN");
    }

    @Override
    protected String getGroupName() {
        return GROUP_NAME;
    }

    protected Integer getRank() {
        return RANK;
    }
}
