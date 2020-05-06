package io.nutritionfacts.api.dataaccess.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_name_mapping", schema = "nutrient_database")
public class FoodNameMappingEntity {
    private String foodName;
    private String foodId;

    @Id
    @Column(name = "food_name", nullable = false, length = 200)
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Column(name = "food_id", nullable = false, length = 5)
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
}
