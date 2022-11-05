package io.nutritionfacts.service.api.model.request;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class FoodRequest {
    @NotEmpty(message = "foodName is mandatory")
    @Size(min = 1, max = 200)
    private String foodName;

    @Digits(integer = 2, fraction = 0)
    private Integer servingSize = 0;
}
