package io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutrient_extra_information", schema = "nutritionfacts")
public class NutrientExtraInformation {
    private String nutrientNumber;
    private String commonName;
    private Double nutrientDailyValue;
    private Boolean isMacronutrient;
    private Boolean isSubcomponent;

    @Id
    @Column(name = "nutrient_number", nullable = false, length = 3)
    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    @Basic
    @Column(name = "common_name", length = 60)
    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @Basic
    @Column(name = "nutrient_daily_value", precision = 3)
    public Double getNutrientDailyValue() {
        return nutrientDailyValue;
    }

    public void setNutrientDailyValue(Double nutrientDailyValue) {
        this.nutrientDailyValue = nutrientDailyValue;
    }

    @Basic
    @Column(name = "is_macronutrient", length = 1)
    public Boolean getMacronutrient() {
        return isMacronutrient;
    }

    public void setMacronutrient(Boolean macronutrient) {
        isMacronutrient = macronutrient;
    }

    @Basic
    @Column(name = "is_subcomponent", length = 1)
    public Boolean getSubcomponent() {
        return isSubcomponent;
    }

    public void setSubcomponent(Boolean subcomponent) {
        isSubcomponent = subcomponent;
    }
}
