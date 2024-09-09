package com.unicauca.smart_consumption.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name="city")
public class CityJPAEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "departamento")
    private String departamento;
}
