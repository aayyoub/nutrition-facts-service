package com.food.information.service.dataaccess.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutrient_extra_information", schema = "nutrient_database")
@DiscriminatorValue("NutrientExtraInformation")
public class NutrientExtraInformationEntity {
    private String nutrientNumber;
    private String nutrientInformation;
    private Double nutrientDailyValue;
    private Boolean displayTop;

    @Id
    @Column(name = "nutrient_number", nullable = false, length = 3)
    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    @Basic
    @Column(name = "nutrient_information", length = 3000)
    public String getNutrientInformation() {
        return nutrientInformation;
    }

    public void setNutrientInformation(String nutrientInformation) {
        this.nutrientInformation = nutrientInformation;
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
    @Column(name = "display_top", length = 1)
    public Boolean getDisplayTop() {
        return displayTop;
    }

    public void setDisplayTop(Boolean displayTop) {
        this.displayTop = displayTop;
    }
}
