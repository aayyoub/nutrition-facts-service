package io.nutritionfacts.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Nutrient {
    private String id;
    @JsonIgnore
    private Double value;
    private String valueRounded;
    private String valueRoundedWithUnit;
    private String valueGaussianRoundedWithUnit;
    private String unit;
    @JsonIgnore
    private Integer roundedToDecimal;
    private String description;
    private String commonName;
    @JsonIgnore
    private String tagname;
    @JsonIgnore
    private Double dailyValue;
    @JsonIgnore
    private Double percentDailyValue;
    private String percentDailyValueFormatted;
    @JsonIgnore
    private Integer sortOrder;
    private Boolean macronutrient;
    private Boolean subcomponent;

    public static Nutrient empty() {
        return Nutrient.builder()
                       .id("00000")
                       .value(0.0)
                       .valueRounded("")
                       .valueRoundedWithUnit("")
                       .unit("")
                       .roundedToDecimal(0)
                       .description("")
                       .tagname("")
                       .dailyValue(0.0)
                       .percentDailyValue(0.0)
                       .percentDailyValueFormatted("")
                       .sortOrder(0)
                       .macronutrient(false)
                       .subcomponent(false)
                       .build();
    }
}
