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

  public FoodDescription getFood(String foodId) {
    try {
      return (FoodDescription) entityManager
          .createNativeQuery("SELECT * FROM food_description WHERE food_description_id = :foodId", FoodDescription.class)
          .setParameter("foodId", foodId)
          .getSingleResult();
    } catch (Exception e) {
      throw new FoodNotFoundException("Error getting food by foodId " + foodId);
    }
  }
}

