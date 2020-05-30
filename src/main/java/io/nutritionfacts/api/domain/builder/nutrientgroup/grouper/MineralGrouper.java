package io.nutritionfacts.api.domain.builder.nutrientgroup.grouper;

import io.nutritionfacts.api.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MineralGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 5;
    private static final String GROUP_NAME = "Minerals";

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
