package io.nutritionfacts.api.dataaccess.jpa.repository.hibernate;

import io.nutritionfacts.api.dataaccess.jpa.entity.ExploreFoodEntity;
import io.nutritionfacts.api.dataaccess.jpa.entity.FoodDescriptionEntity;
import io.nutritionfacts.api.dataaccess.jpa.entity.FoodNameMappingEntity;
import io.nutritionfacts.api.dataaccess.jpa.entity.SearchTermEntity;
import io.nutritionfacts.api.dataaccess.jpa.repository.FoodRepository;
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

    public FoodDescriptionEntity getFood(String foodId) {
        return (FoodDescriptionEntity) entityManager
                .createNativeQuery(
                        "SELECT * FROM food_description WHERE food_description.food_description_id = " +
                                ":foodDescriptionId",
                        FoodDescriptionEntity.class
                )
                .setParameter("foodDescriptionId", foodId)
                .getSingleResult();
    }

    public List<ExploreFoodEntity> getExploreFood() {
        return (List<ExploreFoodEntity>) entityManager
                .createNativeQuery(
                        "SELECT * FROM food_description " +
                                "ORDER BY RAND() " +
                                "LIMIT 0, 35",
                        ExploreFoodEntity.class
                )
                .getResultList();
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

    @Override
    public void save(FoodNameMappingEntity foodNameMappingEntity) {
        entityManager.persist(foodNameMappingEntity);
    }

    @Override
    public FoodNameMappingEntity getFoodByName(String foodName) {
        return (FoodNameMappingEntity) entityManager
                .createNativeQuery(
                        "SELECT * FROM food_name_mapping WHERE food_name = :foodName",
                        FoodNameMappingEntity.class
                )
                .setParameter("foodName", foodName)
                .getSingleResult();
    }
}

