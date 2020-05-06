package io.nutritionfacts.api.domain.builder.nutrientgroup.grouper;

import io.nutritionfacts.api.domain.builder.nutrientgroup.AbstractNutrientGrouper;
import io.nutritionfacts.api.domain.util.NutrientId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FatGrouper extends AbstractNutrientGrouper {
    private static final Integer RANK = 5;
    private static final String GROUP_NAME = "fat";

    @Override
    protected List<String> getRequiredNutrients() {
        return Arrays.asList(
                NutrientId.TOTAL_FAT,
                NutrientId.FATTY_ACIDS_TOTAL_SATURATED,
                NutrientId.F4_0,
                NutrientId.F6_0,
                NutrientId.F8_0,
                NutrientId.F10_0,
                NutrientId.F12_0,
                NutrientId.F13_0,
                NutrientId.F14_0,
                NutrientId.F15_0,
                NutrientId.F16_0,
                NutrientId.F17_0,
                NutrientId.F18_0,
                NutrientId.F20_0,
                NutrientId.F22_0,
                NutrientId.F24_0,
                NutrientId.FATTY_ACIDS_TOTAL_MONOUNSATURATED,
                NutrientId.F14_1,
                NutrientId.F15_1,
                NutrientId.F16_1_UNDIFFERENTIATED,
                NutrientId.F16_1_C,
                NutrientId.F16_1_T,
                NutrientId.F17_1,
                NutrientId.F18_1_UNDIFFERENTIATED,
                NutrientId.F18_1_C,
                NutrientId.F18_1_T,
                NutrientId.F18_1_11_T_18_1T_N_7,
                NutrientId.F20_1,
                NutrientId.F22_1_UNDIFFERENTIATED,
                NutrientId.F22_1_C,
                NutrientId.F22_1_T,
                NutrientId.F24_1_C,
                NutrientId.FATTY_ACIDS_TOTAL_POLYUNSATURATED,
                NutrientId.F18_2_UNDIFFERENTIATED,
                NutrientId.F18_2_N_6_C_C,
                NutrientId.F18_2_CLAS,
                NutrientId.F18_2_T_T,
                NutrientId.F18_2_I,
                NutrientId.F18_2_T_NOT_FURTHER_DEFINED,
                NutrientId.F18_3_UNDIFFERENTIATED,
                NutrientId.F18_3_N_3_C_C_C_ALA,
                NutrientId.F18_3_N_6_C_C_C,
                NutrientId.F18_3I,
                NutrientId.F18_4,
                NutrientId.F20_2_N_6_C_C,
                NutrientId.F20_3_UNDIFFERENTIATED,
                NutrientId.F20_3_N_3,
                NutrientId.F20_3_N_6,
                NutrientId.F20_4_UNDIFFERENTIATED,
                NutrientId.F20_4_N_6,
                NutrientId.F20_5_N_3_EPA,
                NutrientId.F21_5,
                NutrientId.F22_4,
                NutrientId.F22_5_N_3_DPA,
                NutrientId.F22_6_N_3_DHA,
                NutrientId.FATTY_ACIDS_TOTAL_TRANS,
                NutrientId.FATTY_ACIDS_TOTAL_TRANSMONOENOIC,
                NutrientId.FATTY_ACIDS_TOTAL_TRANSPOLYENOIC
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
