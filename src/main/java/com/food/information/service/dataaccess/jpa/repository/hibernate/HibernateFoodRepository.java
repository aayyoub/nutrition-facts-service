package com.food.information.service.dataaccess.jpa.repository.hibernate;

import com.food.information.service.dataaccess.jpa.entity.ExploreFoodEntity;
import com.food.information.service.dataaccess.jpa.entity.FoodDescriptionEntity;
import com.food.information.service.dataaccess.jpa.entity.SearchTermEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
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
                        "SELECT * FROM food_description " +
                                "JOIN nutrient_data ON food_description.food_description_id = nutrient_data.nutrient_data_id " +
                                "JOIN nutrient_definition ON nutrient_data.nutrient_number = nutrient_definition.nutrient_number " +
                                "WHERE food_description.food_description_id = :foodDescriptionId " +
                                "ORDER BY sort_order DESC",
                        FoodDescriptionEntity.class
                )
                .setParameter("foodDescriptionId", foodId)
                .getSingleResult();
    }

    public List<SearchTermEntity> getSearchTerms(String searchTerm) {
        return (List<SearchTermEntity>) entityManager
                .createNativeQuery(
                        "SELECT * FROM food_description " +
                                "WHERE food_description.long_description LIKE :foodNameBeginsWith OR food_description.long_description LIKE :foodNameAnyMatch " +
                                "ORDER BY CASE WHEN food_description.long_description LIKE :foodNameBeginsWith THEN 1 ELSE 2 END " +
                                "LIMIT 0, 20",
                        SearchTermEntity.class
                )
                .setParameter("foodNameBeginsWith", searchTerm + '%')
                .setParameter("foodNameAnyMatch", '%' + searchTerm + '%')
                .getResultList();
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
}

