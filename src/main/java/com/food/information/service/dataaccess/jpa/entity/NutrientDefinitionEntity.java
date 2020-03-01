package com.food.information.service.dataaccess.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutrient_definition", schema = "nutrient_database")
public class NutrientDefinitionEntity {
    private String nutrientNumber;
    private String units;
    private String tagname;
    private String nutrientDescription;
    private String roundedToDecimal;
    private Double nutrientDailyValue;
    private Integer sortOrder;

    @Id
    @Column(name = "nutrient_number", nullable = false, length = 3)
    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    @Basic
    @Column(name = "units", length = 7)
    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Basic
    @Column(name = "tagname", length = 20)
    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Basic
    @Column(name = "nutrient_description", length = 60)
    public String getNutrientDescription() {
        return nutrientDescription;
    }

    public void setNutrientDescription(String nutrientDescription) {
        this.nutrientDescription = nutrientDescription;
    }

    @Basic
    @Column(name = "rounded_to_decimal", length = 1)
    public String getRoundedToDecimal() {
        return roundedToDecimal;
    }

    public void setRoundedToDecimal(String roundedToDecimal) {
        this.roundedToDecimal = roundedToDecimal;
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
    @Column(name = "sort_order", length = 6)
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
