package com.unicauca.smart_consumption.infrastructure.persistence;


import com.unicauca.smart_consumption.infrastructure.entities.ReviewJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJPARepository  extends JpaRepository<ReviewJPAEntity, Long> {
//    List<ReviewJPAEntity> findByProduct(ProductJPAEntity product);
//    List<ReviewJPAEntity> findByUser(UserJPAEntity user);
//    List<ReviewJPAEntity> findReviewsWithMinimumRating(int minRating);
}
