package com.food.information.service.dataaccess.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutrient_extra_information", schema = "nutrient_database")
public class NutrientExtraInformationEntity {
    private String nutrientNumber;
    private String commonName;
    private Double nutrientDailyValue;
    private String externalLink;
    private String goodFor;
    private String badFor;
    private Boolean isMacronutrient;
    private Boolean isSubcomponent;
    private Boolean isBeneficial;
    private Double targetLessThanValue;
    private Double targetMoreThanValue;
    private Double targetLessThanDailyValue;
    private Double targetMoreThanDailyValue;

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
    @Column(name = "external_link", length = 2048)
    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    @Basic
    @Column(name = "good_for", length = 400)
    public String getGoodFor() {
        return goodFor;
    }

    public void setGoodFor(String goodFor) {
        this.goodFor = goodFor;
    }

    @Basic
    @Column(name = "bad_for", length = 400)
    public String getBadFor() {
        return badFor;
    }

    public void setBadFor(String badFor) {
        this.badFor = badFor;
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

    @Basic
    @Column(name = "is_beneficial", length = 1)
    public Boolean getBeneficial() {
        return isBeneficial;
    }

    public void setBeneficial(Boolean beneficial) {
        isBeneficial = beneficial;
    }

    @Basic
    @Column(name = "target_less_than_value", precision = 3)
    public Double getTargetLessThanValue() {
        return targetLessThanValue;
    }

    public void setTargetLessThanValue(Double targetLessThanValue) {
        this.targetLessThanValue = targetLessThanValue;
    }

    @Basic
    @Column(name = "target_more_than_value", precision = 3)
    public Double getTargetMoreThanValue() {
        return targetMoreThanValue;
    }

    public void setTargetMoreThanValue(Double targetGreaterThanValue) {
        this.targetMoreThanValue = targetGreaterThanValue;
    }

    @Basic
    @Column(name = "target_less_than_daily_value", precision = 3)
    public Double getTargetLessThanDailyValue() {
        return targetLessThanDailyValue;
    }

    public void setTargetLessThanDailyValue(Double targetLessThanDailyValue) {
        this.targetLessThanDailyValue = targetLessThanDailyValue;
    }

    @Basic
    @Column(name = "target_more_than_daily_value", precision = 3)
    public Double getTargetMoreThanDailyValue() {
        return targetMoreThanDailyValue;
    }

    public void setTargetMoreThanDailyValue(Double targetMoreThanDailyValue) {
        this.targetMoreThanDailyValue = targetMoreThanDailyValue;
    }
}
