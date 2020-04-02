package com.food.information.service.domain.model;

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
    private Boolean displayTop;

    public static Nutrient empty() {
        return new Nutrient("0", 0.0, "", "", "", 0, "", "", 0.0, 0.0, "", 0, false);
    }
}
