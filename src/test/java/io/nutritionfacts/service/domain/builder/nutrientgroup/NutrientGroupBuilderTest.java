package io.nutritionfacts.service.domain.builder.nutrientgroup;

import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.CarbohydrateGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.EnergyGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.FatGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.MineralGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.OtherGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.ProteinGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.SterolGrouper;
import io.nutritionfacts.service.domain.builder.nutrientgroup.grouper.VitaminGrouper;
import io.nutritionfacts.service.domain.model.Nutrient;
import io.nutritionfacts.service.domain.model.NutrientGroup;
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
                Map.entry("318", Nutrient.builder().id("318").sortOrder(7500).description("Vitamin A, IU").build()),
                Map.entry("324", Nutrient.builder().id("324").sortOrder(8750).description("Vitamin D").build()),
                Map.entry("401", Nutrient.builder().id("401").sortOrder(6300).description("Vitamin C, total ascorbic acid").build()),
                Map.entry("301", Nutrient.builder().id("301").sortOrder(5300).description("Calcium, Ca").build()),
                Map.entry("303", Nutrient.builder().id("303").sortOrder(5400).description("Iron, Fe").build()),
                Map.entry("304", Nutrient.builder().id("304").sortOrder(5500).description("Magnesium, Mg").build()),
                Map.entry("203", Nutrient.builder().id("203").sortOrder(600).description("Protein").build()),
                Map.entry("515", Nutrient.builder().id("515").sortOrder(17700).description("Glutamic acid").build()),
                Map.entry("504", Nutrient.builder().id("504").sortOrder(16600).description("Leucine").build()),
                Map.entry("205", Nutrient.builder().id("205").sortOrder(1100).description("Carbohydrate, by difference").build()),
                Map.entry("209", Nutrient.builder().id("209").sortOrder(2200).description("Starch").build()),
                Map.entry("210", Nutrient.builder().id("210").sortOrder(1600).description("Sucrose").build()),
                Map.entry("645", Nutrient.builder().id("645").sortOrder(11400).description("Fatty acids, total monounsaturated").build()),
                Map.entry("646", Nutrient.builder().id("646").sortOrder(12900).description("Fatty acids, total polyunsaturated").build()),
                Map.entry("652", Nutrient.builder().id("652").sortOrder(10600).description("15:0").build()),
                Map.entry("636", Nutrient.builder().id("636").sortOrder(15800).description("Phytosterols").build()),
                Map.entry("638", Nutrient.builder().id("638").sortOrder(15900).description("Stigmasterol").build()),
                Map.entry("255", Nutrient.builder().id("255").sortOrder(100).description("Water").build()),
                Map.entry("207", Nutrient.builder().id("207").sortOrder(1000).tagname("Ash").build()),
                Map.entry("208", Nutrient.builder().id("208").sortOrder(300).tagname("Energy").build()),
                Map.entry("268", Nutrient.builder().id("268").sortOrder(400).tagname("Energy").build()));
    }

    private void givenNutrientBuilder() {
        List<NutrientGrouper> nutrientGroupers = Arrays.asList(
                new EnergyGrouper(),
                new ProteinGrouper(),
                new CarbohydrateGrouper(),
                new FatGrouper(),
                new VitaminGrouper(),
                new MineralGrouper(),
                new SterolGrouper(),
                new OtherGrouper());

        nutrientGroupBuilder = new NutrientGroupBuilder(nutrientGroupers);
    }

    private void buildNutrients() {
        results = nutrientGroupBuilder.buildNutrientGroups(nutrients);
    }

    private void verifyResults() {
        assertThat(results.get(0).getRank()).isEqualTo(0);
        assertThat(results.get(0).getGroupName()).isEqualTo("Energy");
        assertThat(results.get(0).getNutrients().get(0).getId()).isEqualTo("208");
        assertThat(results.get(0).getNutrients().get(1).getId()).isEqualTo("268");

        assertThat(results.get(1).getRank()).isEqualTo(1);
        assertThat(results.get(1).getGroupName()).isEqualTo("Protein and Amino Acids");
        assertThat(results.get(1).getNutrients().get(0).getId()).isEqualTo("203");
        assertThat(results.get(1).getNutrients().get(1).getId()).isEqualTo("504");
        assertThat(results.get(1).getNutrients().get(2).getId()).isEqualTo("515");

        assertThat(results.get(2).getRank()).isEqualTo(2);
        assertThat(results.get(2).getGroupName()).isEqualTo("Carbohydrates");
        assertThat(results.get(2).getNutrients().get(0).getId()).isEqualTo("205");
        assertThat(results.get(2).getNutrients().get(1).getId()).isEqualTo("210");
        assertThat(results.get(2).getNutrients().get(2).getId()).isEqualTo("209");

        assertThat(results.get(3).getRank()).isEqualTo(3);
        assertThat(results.get(3).getGroupName()).isEqualTo("Fats and Fatty Acids");
        assertThat(results.get(3).getNutrients().get(0).getId()).isEqualTo("652");
        assertThat(results.get(3).getNutrients().get(1).getId()).isEqualTo("645");
        assertThat(results.get(3).getNutrients().get(2).getId()).isEqualTo("646");

        assertThat(results.get(4).getRank()).isEqualTo(4);
        assertThat(results.get(4).getGroupName()).isEqualTo("Vitamins");
        assertThat(results.get(4).getNutrients().get(0).getId()).isEqualTo("401");
        assertThat(results.get(4).getNutrients().get(1).getId()).isEqualTo("318");
        assertThat(results.get(4).getNutrients().get(2).getId()).isEqualTo("324");

        assertThat(results.get(5).getRank()).isEqualTo(5);
        assertThat(results.get(5).getGroupName()).isEqualTo("Minerals");
        assertThat(results.get(5).getNutrients().get(0).getId()).isEqualTo("301");
        assertThat(results.get(5).getNutrients().get(1).getId()).isEqualTo("303");
        assertThat(results.get(5).getNutrients().get(2).getId()).isEqualTo("304");

        assertThat(results.get(6).getRank()).isEqualTo(6);
        assertThat(results.get(6).getGroupName()).isEqualTo("Sterols");
        assertThat(results.get(6).getNutrients().get(0).getId()).isEqualTo("636");
        assertThat(results.get(6).getNutrients().get(1).getId()).isEqualTo("638");

        assertThat(results.get(7).getRank()).isEqualTo(7);
        assertThat(results.get(7).getGroupName()).isEqualTo("Other");
        assertThat(results.get(7).getNutrients().get(0).getId()).isEqualTo("255");
        assertThat(results.get(7).getNutrients().get(1).getId()).isEqualTo("207");
    }
}
