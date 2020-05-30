package io.nutritionfacts.api.domain.model;

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
public class ServingSize {
    private Integer order;
    private String description;
    private Double gramWeight;

    public static ServingSize empty() {
        return new ServingSize(0, "", 1.0);
    }
}
