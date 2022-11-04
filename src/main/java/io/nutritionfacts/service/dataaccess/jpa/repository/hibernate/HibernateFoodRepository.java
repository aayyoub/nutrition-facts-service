package io.nutritionfacts.service.dataaccess.jpa.repository.hibernate;

import io.nutritionfacts.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import io.nutritionfacts.service.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.service.dataaccess.jpa.entity.SearchTermEntity;
import io.nutritionfacts.service.dataaccess.jpa.repository.FoodRepository;
import io.nutritionfacts.service.exception.ErrorMessageCode;
import io.nutritionfacts.service.exception.FoodNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateFoodRepository implements FoodRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FoodNameMappingEntity getFoodIdByName(String foodName) {
        try {
            return (FoodNameMappingEntity) entityManager
                    .createNativeQuery(
                            "SELECT * FROM nutritionfacts.food_name_mapping WHERE food_name = :foodName",
                            FoodNameMappingEntity.class
                    )
                    .setParameter("foodName", foodName)
                    .getSingleResult();
        } catch (Exception e) {
            throw new FoodNotFoundException("Error getting foodId from foodName " + foodName);
        }
    }

    public FoodDescriptionEntity getFood(String foodId) {
        try {
            return (FoodDescriptionEntity) entityManager
                    .createNativeQuery(
                            "SELECT * FROM food_description WHERE food_description.food_description_id = " +
                                    ":foodDescriptionId",
                            FoodDescriptionEntity.class
                    )
                    .setParameter("foodDescriptionId", foodId)
                    .getSingleResult();
        } catch (Exception e) {
            throw new FoodNotFoundException("Error getting food by foodId " + foodId);
        }
    }

    @Override
    public List<SearchTermEntity> getAllLinks() {
        return (List<SearchTermEntity>) entityManager
                .createNativeQuery(
                        "SELECT * FROM food_description ",
                        SearchTermEntity.class
                )
                .getResultList();
    }
}

