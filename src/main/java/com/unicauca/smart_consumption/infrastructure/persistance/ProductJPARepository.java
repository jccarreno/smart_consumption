package com.unicauca.smart_consumption.infrastructure.persistance;


import com.unicauca.smart_consumption.domain.model.valueObject.Category;
import com.unicauca.smart_consumption.domain.model.valueObject.Rating;
import com.unicauca.smart_consumption.domain.model.valueObject.SustainabilityCriteria;
import com.unicauca.smart_consumption.infrastructure.entities.ProductJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProductJPARepository extends JpaRepository<ProductJPAEntity,Long>{
//    List<ProductJPAEntity> findByCategory(Category category);
//    List<ProductJPAEntity> findByNameContaining(String name);
//    List<ProductJPAEntity> findBySustainabilityCriteria(SustainabilityCriteria criteria);
//    List<ProductJPAEntity> findSustainableProducts(@Param("threshold") double threshold);
//    List<ProductJPAEntity> findByRating(Rating rating);
//    List<ProductJPAEntity> findProductsByRatingGreaterThanEqual(@Param("rating") Rating rating);
}