package io.nutritionfacts.service.domain.model;

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
public class CaloricPyramid {
    private String alcoholPercentage;
    private String carbohydratePercentage;
    private String fatPercentage;
    private String proteinPercentage;
}
