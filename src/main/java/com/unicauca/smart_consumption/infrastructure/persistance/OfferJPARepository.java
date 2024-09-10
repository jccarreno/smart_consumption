package com.unicauca.smart_consumption.infrastructure.persistance;

import com.unicauca.smart_consumption.infrastructure.entities.OfferJPAEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferJPARepository  extends JpaRepository<OfferJPAEntity,Long> {
}
