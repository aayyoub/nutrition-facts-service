package io.nutritionfacts.service.dataaccess.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "weight", schema = "nutrient_database")
public class WeightEntity implements Serializable {
    private String weightId;
    private String sequenceNumber;
    private Double amount;
    private String measurementDescription;
    private Double gramWeight;
    private Integer numberOfDataPoints;
    private Double standardDeviation;

    @Id
    @Column(name = "weight_id", nullable = false, length = 5)
    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
    }

    @Id
    @Column(name = "sequence_number", nullable = false, length = 2)
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Column(name = "amount", precision = 3)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "measurement_description", length = 84)
    public String getMeasurementDescription() {
        return measurementDescription;
    }

    public void setMeasurementDescription(String measurementDescription) {
        this.measurementDescription = measurementDescription;
    }

    @Column(name = "gram_weight", precision = 2)
    public Double getGramWeight() {
        return gramWeight;
    }

    public void setGramWeight(Double gramWeight) {
        this.gramWeight = gramWeight;
    }

    @Column(name = "number_of_data_points", length = 3)
    public Integer getNumberOfDataPoints() {
        return numberOfDataPoints;
    }

    public void setNumberOfDataPoints(Integer numberOfDataPoints) {
        this.numberOfDataPoints = numberOfDataPoints;
    }

    @Column(name = "standard_deviation", precision = 3)
    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
}
