package com.unicauca.smart_consumption.infrastructure.persistence;



import com.unicauca.smart_consumption.infrastructure.entities.StoreJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJPARepository  extends JpaRepository<StoreJPAEntity, Long> {

}
