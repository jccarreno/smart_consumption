package com.unicauca.smart_consumption.infrastructure.entities;
import com.unicauca.smart_consumption.domain.model.Product;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "offer")
public class OfferJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductJPAEntity producto;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "detalles")
    private String detalles;
}
