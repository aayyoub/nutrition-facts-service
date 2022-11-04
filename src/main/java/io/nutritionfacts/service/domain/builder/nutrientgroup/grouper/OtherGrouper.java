package io.nutritionfacts.service.domain.builder.nutrientgroup.grouper;

import io.nutritionfacts.service.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import io.nutritionfacts.service.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OtherGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 7;
    private static final String GROUP_NAME = "Other";

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
