package com.unicauca.smart_consumption.infrastructure.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class ProductJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "sostenibilidad")
    private double sostenibilidad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "disponible")
    private boolean disponible;

    @Column(name = "precio_base")
    private double precioBase;

    @ManyToMany(mappedBy = "productos")
    private List<StoreJPAEntity> stores;
}
