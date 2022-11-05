package io.nutritionfacts.service.domain.food.formatter.components.grouper;

import io.nutritionfacts.service.domain.food.formatter.components.AbstractNutrientGrouper;
import io.nutritionfacts.service.domain.food.formatter.components.NutrientId;
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
