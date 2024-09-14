package com.unicauca.smart_consumption.infrastructure.user.dataproviders;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, Long> {

}
