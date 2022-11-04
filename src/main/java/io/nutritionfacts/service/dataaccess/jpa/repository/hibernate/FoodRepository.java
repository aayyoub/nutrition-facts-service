package io.nutritionfacts.service.dataaccess.jpa.repository.hibernate;

import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodDescription;
import io.nutritionfacts.service.dataaccess.jpa.repository.hibernate.entity.FoodNameMapping;
import io.nutritionfacts.service.exception.FoodNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FoodRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public FoodRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public FoodNameMapping getFoodId(String foodName) {
        try {
            var result = entityManager.createNativeQuery(
                            "SELECT * FROM food_name_mapping WHERE food_name = :foodName", FoodNameMapping.class
                    )
                    .setParameter("foodName", foodName)
                    .getSingleResult();

            return (FoodNameMapping) result;
        } catch (Exception e) {
            throw new FoodNotFoundException("Error getting food by foodName: " + foodName);
        }
    }

    public FoodDescription getFood(String foodId) {
        try {
            var result = entityManager.createNativeQuery(
                            "SELECT * FROM food_description WHERE food_description.food_description_id = :foodDescriptionId",
                            FoodDescription.class
                    )
                    .setParameter("foodDescriptionId", foodId)
                    .getSingleResult();

            return (FoodDescription) result;
        } catch (Exception e) {
            throw new FoodNotFoundException("Error getting food by foodId " + foodId);
        }
    }
}

