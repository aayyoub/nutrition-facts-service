package com.food.information.service.domain.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutrient {
    private String id;
    private Double value;
    private String valueRounded;
    private String valueFormatted;
    private String unit;
    private Integer roundedToDecimal;
    private String description;
    private String tagname;
    private Double dailyValue;
    private Double percentDailyValue;
    private String percentDailyValueFormatted;
    private Integer sortOrder;
    private String externalLink;
    private JsonNode goodFor;
    private JsonNode badFor;
    private Boolean macronutrient;
    private Boolean subcomponent;

    public static Nutrient empty() {
        return Nutrient.builder().id("00000").value(0.0).valueRounded("").valueFormatted("").unit("").roundedToDecimal(0).description("").tagname("").dailyValue(0.0).percentDailyValue(0.0).percentDailyValueFormatted("").sortOrder(0).macronutrient(false).subcomponent(false).build();
    }
}
