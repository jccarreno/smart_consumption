package com.unicauca.smart_consumption.infrastructure.persistence;


import com.unicauca.smart_consumption.infrastructure.entities.UserJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, Long> {

}
