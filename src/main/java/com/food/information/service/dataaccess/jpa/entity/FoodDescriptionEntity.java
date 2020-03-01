package com.food.information.service.dataaccess.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "food_description", schema = "nutrient_database")
public class FoodDescriptionEntity {
    private String foodDescriptionId;
    private String foodGroupCode;
    private String longDescription;
    private String shortDescription;
    private String commonName;
    private String manufacturerName;
    private String isSurvey;
    private String refuseDescription;
    private Integer refusePercentage;
    private String scientificName;
    private Double nFactor;
    private Double proFactor;
    private Double fatFactor;
    private Double choFactor;
    private List<NutrientDataEntity> nutrientDatumEntities;

    @Id
    @Column(name = "food_description_id", nullable = false, length = 5)
    public String getFoodDescriptionId() {
        return foodDescriptionId;
    }

    public void setFoodDescriptionId(String foodDescriptionId) {
        this.foodDescriptionId = foodDescriptionId;
    }

    @Basic
    @Column(name = "food_group_code", length = 4)
    public String getFoodGroupCode() {
        return foodGroupCode;
    }

    public void setFoodGroupCode(String foodGroupCode) {
        this.foodGroupCode = foodGroupCode;
    }

    @Basic
    @Column(name = "long_description", length = 200)
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Basic
    @Column(name = "short_description", length = 60)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "common_name", length = 100)
    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @Basic
    @Column(name = "manufacturer_name", length = 65)
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Basic
    @Column(name = "is_survey", length = 1)
    public String getIsSurvey() {
        return isSurvey;
    }

    public void setIsSurvey(String isSurvey) {
        this.isSurvey = isSurvey;
    }

    @Basic
    @Column(name = "refuse_description", length = 135)
    public String getRefuseDescription() {
        return refuseDescription;
    }

    public void setRefuseDescription(String refuseDescription) {
        this.refuseDescription = refuseDescription;
    }

    @Basic
    @Column(name = "refuse_percentage")
    public Integer getRefusePercentage() {
        return refusePercentage;
    }

    public void setRefusePercentage(Integer refusePercentage) {
        this.refusePercentage = refusePercentage;
    }

    @Basic
    @Column(name = "scientific_name", length = 65)
    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @Basic
    @Column(name = "n_factor", precision = 2)
    public Double getnFactor() {
        return nFactor;
    }

    public void setnFactor(Double nFactor) {
        this.nFactor = nFactor;
    }

    @Basic
    @Column(name = "pro_factor", precision = 2)
    public Double getProFactor() {
        return proFactor;
    }

    public void setProFactor(Double proFactor) {
        this.proFactor = proFactor;
    }

    @Basic
    @Column(name = "fat_factor", precision = 2)
    public Double getFatFactor() {
        return fatFactor;
    }

    public void setFatFactor(Double fatFactor) {
        this.fatFactor = fatFactor;
    }

    @Basic
    @Column(name = "cho_factor", precision = 2)
    public Double getChoFactor() {
        return choFactor;
    }

    public void setChoFactor(Double choFactor) {
        this.choFactor = choFactor;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nutrient_data_id")
    public List<NutrientDataEntity> getNutrientDatumEntities() {
        return nutrientDatumEntities;
    }

    public void setNutrientDatumEntities(List<NutrientDataEntity> nutrientDatumEntities) {
        this.nutrientDatumEntities = nutrientDatumEntities;
    }
}
