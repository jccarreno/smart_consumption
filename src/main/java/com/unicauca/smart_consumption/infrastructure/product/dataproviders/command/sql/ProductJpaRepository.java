package com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository <ProductJpaEntity,String>{
//    List<ProductJPAEntity> findByCategory(Category category);
//    List<ProductJPAEntity> findByNameContaining(String name);
//    List<ProductJPAEntity> findBySustainabilityCriteria(SustainabilityCriteria criteria);
//    List<ProductJPAEntity> findSustainableProducts(@Param("threshold") double threshold);
//    List<ProductJPAEntity> findByRating(Rating rating);
//    List<ProductJPAEntity> findProductsByRatingGreaterThanEqual(@Param("rating") Rating rating);
}