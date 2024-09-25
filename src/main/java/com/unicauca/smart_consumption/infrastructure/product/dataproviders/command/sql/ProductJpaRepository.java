package com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository <ProductJpaEntity,String>{

}