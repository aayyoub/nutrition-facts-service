package com.food.information.service.dataaccess.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nutrient_data", schema = "nutrient_database")
public class NutrientDataEntity {
    private String nutrientDataId;
    private String nutrientNumber;
    private Double nutrientValue;
    private Integer NumberOfDataPoints;
    private Double standardError;
    private String sourceCode;
    private String derivationCode;
    private String referenceNdbNumber;
    private String addedNutrientMark;
    private Integer numberOfStudies;
    private Double min;
    private Double max;
    private Integer degreesOfFreedom;
    private Double lowerErrorBound;
    private Double upperErrorBound;
    private String statisticalComments;
    private String addedModifiedDate;
    private String confidenceCode;
    private NutrientDefinitionEntity nutrientDefinitionEntity;

    @Column(name = "nutrient_data_id", length = 5)
    public String getNutrientDataId() {
        return nutrientDataId;
    }

    public void setNutrientDataId(String nutrientDataId) {
        this.nutrientDataId = nutrientDataId;
    }

    @Id
    @Column(name = "nutrient_number", length = 3)
    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    @Column(name = "nutrient_value", precision = 3)
    public Double getNutrientValue() {
        return nutrientValue;
    }

    public void setNutrientValue(Double nutrientValue) {
        this.nutrientValue = nutrientValue;
    }

    @Column(name = "number_of_data_points", length = 5)
    public Integer getNumberOfDataPoints() {
        return NumberOfDataPoints;
    }

    public void setNumberOfDataPoints(Integer numberOfDataPoints) {
        NumberOfDataPoints = numberOfDataPoints;
    }

    @Column(name = "standard_error", precision = 3)
    public Double getStandardError() {
        return standardError;
    }

    public void setStandardError(Double standardError) {
        this.standardError = standardError;
    }

    @Column(name = "source_code", length = 2)
    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Column(name = "derivation_code", length = 4)
    public String getDerivationCode() {
        return derivationCode;
    }

    public void setDerivationCode(String derivationCode) {
        this.derivationCode = derivationCode;
    }

    @Column(name = "reference_ndb_number", length = 5)
    public String getReferenceNdbNumber() {
        return referenceNdbNumber;
    }

    public void setReferenceNdbNumber(String referenceNdbNumber) {
        this.referenceNdbNumber = referenceNdbNumber;
    }

    @Column(name = "added_nutrient_mark", length = 1)
    public String getAddedNutrientMark() {
        return addedNutrientMark;
    }

    public void setAddedNutrientMark(String addedNutrientMark) {
        this.addedNutrientMark = addedNutrientMark;
    }

    @Column(name = "number_of_studies", length = 2)
    public Integer getNumberOfStudies() {
        return numberOfStudies;
    }

    public void setNumberOfStudies(Integer numberOfStudies) {
        this.numberOfStudies = numberOfStudies;
    }

    @Column(name = "min", precision = 3)
    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    @Column(name = "max", precision = 3)
    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @Column(name = "degrees_of_freedom", length = 4)
    public Integer getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    public void setDegreesOfFreedom(Integer degreesOfFreedom) {
        this.degreesOfFreedom = degreesOfFreedom;
    }

    @Column(name = "lower_error_bound", precision = 3)
    public Double getLowerErrorBound() {
        return lowerErrorBound;
    }

    public void setLowerErrorBound(Double lowerErrorBound) {
        this.lowerErrorBound = lowerErrorBound;
    }

    @Column(name = "upper_error_bound", precision = 3)
    public Double getUpperErrorBound() {
        return upperErrorBound;
    }

    public void setUpperErrorBound(Double upperErrorBound) {
        this.upperErrorBound = upperErrorBound;
    }

    @Column(name = "statistical_comments", length = 10)
    public String getStatisticalComments() {
        return statisticalComments;
    }

    public void setStatisticalComments(String statisticalComments) {
        this.statisticalComments = statisticalComments;
    }

    @Column(name = "added_modified_date", length = 10)
    public String getAddedModifiedDate() {
        return addedModifiedDate;
    }

    public void setAddedModifiedDate(String addedModifiedDate) {
        this.addedModifiedDate = addedModifiedDate;
    }

    @Column(name = "confidence_code", length = 1)
    public String getConfidenceCode() {
        return confidenceCode;
    }

    public void setConfidenceCode(String confidenceCode) {
        this.confidenceCode = confidenceCode;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nutrient_number", insertable = false, updatable = false)
    public NutrientDefinitionEntity getNutrientDefinitionEntity() {
        return nutrientDefinitionEntity;
    }

    public void setNutrientDefinitionEntity(NutrientDefinitionEntity nutrientDefinitionEntity) {
        this.nutrientDefinitionEntity = nutrientDefinitionEntity;
    }
}
