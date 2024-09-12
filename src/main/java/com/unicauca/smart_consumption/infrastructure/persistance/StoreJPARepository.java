package com.unicauca.smart_consumption.infrastructure.persistance;



import com.unicauca.smart_consumption.infrastructure.entities.ProductJPAEntity;
import com.unicauca.smart_consumption.infrastructure.entities.StoreJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreJPARepository  extends JpaRepository<StoreJPAEntity, Long> {

}
