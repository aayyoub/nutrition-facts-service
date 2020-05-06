package io.nutritionfacts.api.dataaccess.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_description", schema = "nutrient_database")
public class ExploreFoodEntity {
    private String foodDescriptionId;
    private String longDescription;

    @Id
    @Column(name = "food_description_id", nullable = false, length = 5)
    public String getFoodDescriptionId() {
        return foodDescriptionId;
    }

    public void setFoodDescriptionId(String foodDescriptionId) {
        this.foodDescriptionId = foodDescriptionId;
    }

    @Basic
    @Column(name = "long_description", length = 200)
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
