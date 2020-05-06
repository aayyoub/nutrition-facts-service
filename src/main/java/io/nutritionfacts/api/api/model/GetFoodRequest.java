package io.nutritionfacts.api.api.model;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class GetFoodRequest {
    @NotNull
    @Size(min = 1, max = 200)
    private String foodName;

    @PositiveOrZero
    @Digits(integer = 2, fraction = 0)
    private Integer servingSize = 0;
}
