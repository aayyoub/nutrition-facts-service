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
public class ServingSize {
    private Integer order;
    private String description;
    private Double gramWeight;

    public static ServingSize empty() {
        return new ServingSize(0, "", 1.0);
    }
}
