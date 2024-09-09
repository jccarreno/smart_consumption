package com.unicauca.smart_consumption.infrastructure.entities;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "user")
public class UserJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "user_offer",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "oferta_id")
    )
    private List<OfferJPAEntity> listaSeguimiento;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private CityJPAEntitiy ubicacion;
}
