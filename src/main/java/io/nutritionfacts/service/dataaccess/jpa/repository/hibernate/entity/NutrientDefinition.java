package io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nutrient_definition", schema = "nutritionfacts")
public class NutrientDefinition {
    private String nutrientNumber;
    private String units;
    private String tagname;
    private String nutrientDescription;
    private String roundedToDecimal;
    private Integer sortOrder;
    private NutrientExtraInformation nutrientExtraInformation;

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
    @Column(name = "sort_order", length = 6)
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nutrient_number", insertable = false, updatable = false)
    public NutrientExtraInformation getNutrientExtraInformationEntity() {
        return nutrientExtraInformation;
    }

    public void setNutrientExtraInformationEntity(NutrientExtraInformation nutrientExtraInformation) {
        this.nutrientExtraInformation = nutrientExtraInformation;
    }
}
