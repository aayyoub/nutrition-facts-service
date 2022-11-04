package io.nutritionfacts.service.domain.model;

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
}
