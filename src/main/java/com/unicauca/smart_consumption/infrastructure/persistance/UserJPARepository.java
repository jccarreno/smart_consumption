package com.unicauca.smart_consumption.infrastructure.persistance;


import com.unicauca.smart_consumption.infrastructure.entities.UserJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, Long> {
    List<UserJPAEntity> findByNameContaining(String name);
    @Query("SELECT u FROM User u JOIN u.reviews r WHERE r.rating = 'EXCELLENT' OR r.rating = 'GOOD'")
    List<UserJPAEntity> findUsersWithPositiveReviews();
}
