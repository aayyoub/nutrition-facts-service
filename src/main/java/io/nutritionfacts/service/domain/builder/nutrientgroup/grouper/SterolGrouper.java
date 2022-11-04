package io.nutritionfacts.service.domain.builder.nutrientgroup.grouper;

import io.nutritionfacts.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import io.nutritionfacts.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SterolGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 6;
    private static final String GROUP_NAME = "Sterols";

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
