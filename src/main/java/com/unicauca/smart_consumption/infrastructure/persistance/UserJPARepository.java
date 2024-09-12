package com.unicauca.smart_consumption.infrastructure.persistance;


import com.unicauca.smart_consumption.infrastructure.entities.UserJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, Long> {

}
