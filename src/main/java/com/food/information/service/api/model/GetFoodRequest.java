package com.food.information.service.api.model;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class GetFoodRequest {
    @NotNull
    @Size(min = 5, max = 5)
    private String foodId;

    @PositiveOrZero
    @Digits(integer = 2, fraction = 0)
    private Integer servingSize = 0;
}
