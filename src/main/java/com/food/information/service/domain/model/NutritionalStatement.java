package com.food.information.service.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NutritionalStatement {
    boolean isBeneficial;
    String analysisStatement;
}
