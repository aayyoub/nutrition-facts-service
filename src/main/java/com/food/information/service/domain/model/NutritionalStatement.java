package com.food.information.service.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Builder
public class NutritionalStatement {
    boolean isBeneficial;
    String analysisStatement;
}
