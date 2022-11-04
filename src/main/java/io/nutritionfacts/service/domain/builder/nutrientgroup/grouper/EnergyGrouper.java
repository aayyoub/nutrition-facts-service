package io.nutritionfacts.service.domain.builder.nutrientgroup.grouper;

import io.nutritionfacts.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import io.nutritionfacts.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EnergyGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 0;
    private static final String GROUP_NAME = "Energy";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(
                NutrientId.ENERGY_KCAL,
                NutrientId.ENERGY_KJ
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
