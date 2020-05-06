package io.nutritionfacts.api.domain.builder.nutrientgroup.grouper;

import io.nutritionfacts.api.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SterolGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 6;
    private static final String GROUP_NAME = "sterols";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(
                NutrientId.CHOLESTEROL,
                NutrientId.PHYTOSTEROLS,
                NutrientId.STIGMASTEROL,
                NutrientId.CAMPESTEROL,
                NutrientId.BETASITOSTEROL
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
