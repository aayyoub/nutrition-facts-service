package com.food.information.service.testutils.builder;

import com.food.information.service.domain.model.Nutrient;

public class NutrientBuilder {
    private String id;
    private Double value;
    private String valueFormatted;
    private String unit;
    private String description;
    private String tagname;
    private Double dailyValue;
    private Double percentDailyValue;
    private String percentDailyValueFormatted;
    private Integer sortOrder;

    public static NutrientBuilder aNutrientBuilder() {
        return new NutrientBuilder();
    }

    public NutrientBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public NutrientBuilder withValue(Double value) {
        this.value = value;
        return this;
    }

    public NutrientBuilder withTagname(String tagname) {
        this.tagname = tagname;
        return this;
    }

    public NutrientBuilder withDailyValue(Double dailyValue) {
        this.dailyValue = dailyValue;
        return this;
    }

    public NutrientBuilder withSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Nutrient build() {
        Nutrient nutrient = new Nutrient();
        nutrient.setId(id);
        nutrient.setValue(value);
        nutrient.setTagname(tagname);
        nutrient.setDailyValue(dailyValue);
        nutrient.setSortOrder(sortOrder);

        return nutrient;
    }
}
