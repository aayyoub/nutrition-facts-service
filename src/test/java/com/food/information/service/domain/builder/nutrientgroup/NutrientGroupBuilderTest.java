package com.food.information.service.domain.builder.nutrientgroup;

import com.food.information.service.domain.builder.nutrientgroup.grouper.MineralGrouper;
import com.food.information.service.domain.builder.nutrientgroup.grouper.OtherGrouper;
import com.food.information.service.domain.builder.nutrientgroup.grouper.OverviewGrouper;
import com.food.information.service.domain.builder.nutrientgroup.grouper.VitaminGrouper;
import com.food.information.service.domain.model.Nutrient;
import com.food.information.service.domain.model.NutrientGroup;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class NutrientGroupBuilderTest {
    private Map<String, Nutrient> nutrients;
    private NutrientGroupBuilder nutrientGroupBuilder;
    private List<NutrientGroup> results;

    @Test
    public void testNutrientGroupBuilder() {
        givenNutrients();

        givenNutrientBuilder();

        buildNutrients();

        verifyResults();
    }

    private void givenNutrients() {
        nutrients = Map.ofEntries(
                Map.entry("318", Nutrient.builder().id("318").sortOrder(0).percentDailyValue(1.0).tagname("VITA_IU").build()),
                Map.entry("203", Nutrient.builder().id("203").sortOrder(1).percentDailyValue(2.0).tagname("PROCNT").build()),
                Map.entry("301", Nutrient.builder().id("301").sortOrder(2).percentDailyValue(3.0).tagname("CA").build()),
                Map.entry("255", Nutrient.builder().id("255").sortOrder(3).percentDailyValue(4.0).tagname("WATER").build()));
    }

    private void givenNutrientBuilder() {
        List<NutrientGrouper> nutrientGroupers = Arrays.asList(new OverviewGrouper(), new VitaminGrouper(), new MineralGrouper(), new OtherGrouper());

        nutrientGroupBuilder = new NutrientGroupBuilder(nutrientGroupers);
    }

    private void buildNutrients() {
        results = nutrientGroupBuilder.buildNutrientGroups(nutrients);
    }

    private void verifyResults() {
        assertThat(results.get(0).getRank()).isEqualTo(1);
        assertThat(results.get(0).getGroupName()).isEqualTo("overview");
        assertThat(results.get(0).getNutrients().get(0).getId()).isEqualTo("255");
        assertThat(results.get(0).getNutrients().get(1).getId()).isEqualTo("203");

        assertThat(results.get(1).getRank()).isEqualTo(2);
        assertThat(results.get(1).getGroupName()).isEqualTo("vitamins");
        assertThat(results.get(1).getNutrients().get(0).getId()).isEqualTo("318");

        assertThat(results.get(2).getRank()).isEqualTo(3);
        assertThat(results.get(2).getGroupName()).isEqualTo("minerals");
        assertThat(results.get(2).getNutrients().get(0).getId()).isEqualTo("301");

        assertThat(results.get(3).getRank()).isEqualTo(4);
        assertThat(results.get(3).getGroupName()).isEqualTo("other");
        assertThat(results.get(3).getNutrients().get(0).getId()).isEqualTo("255");
    }
}