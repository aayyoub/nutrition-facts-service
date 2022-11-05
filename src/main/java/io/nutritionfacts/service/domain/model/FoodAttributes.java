package io.nutritionfacts.service.domain.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class FoodAttributes {
  @NotEmpty
  @Size(min = 5, max = 5)
  public FoodId foodId;

  @Digits(integer = 2, fraction = 0)
  public Integer servingSize = 0;
}
