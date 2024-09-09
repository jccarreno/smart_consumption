package com.unicauca.smart_consumption.infrastructure.entities;
import com.unicauca.smart_consumption.domain.model.City;
import com.unicauca.smart_consumption.domain.model.Offer;
import com.unicauca.smart_consumption.domain.model.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "store")
public class StoreJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @ManyToMany
    @JoinTable(
            name = "store_product",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<ProductJPAEntity> productos;

    @OneToMany
    @JoinColumn(name = "oferta_id")
    private List<OfferJPAEntity> ofertas;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private CityJPAEntitiy ubicacion;
}
