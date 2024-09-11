package com.unicauca.smart_consumption.infrastructure.persistance;


import com.unicauca.smart_consumption.infrastructure.entities.ProductJPAEntity;
import com.unicauca.smart_consumption.infrastructure.entities.ReviewJPAEntity;
import com.unicauca.smart_consumption.infrastructure.entities.UserJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewJPARepository  extends JpaRepository<ReviewJPAEntity, Long> {
//    List<ReviewJPAEntity> findByProduct(ProductJPAEntity product);
//    List<ReviewJPAEntity> findByUser(UserJPAEntity user);
//    List<ReviewJPAEntity> findReviewsWithMinimumRating(int minRating);
}
