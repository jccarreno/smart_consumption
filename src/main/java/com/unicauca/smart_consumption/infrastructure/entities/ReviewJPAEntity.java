package com.unicauca.smart_consumption.infrastructure.entities;
import com.unicauca.smart_consumption.domain.model.Product;
import com.unicauca.smart_consumption.domain.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "review")
public class ReviewJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductJPAEntity producto;

    @Column(name = "calificacion")
    private int calificacion;

    @Column(name = "publicacion")
    private LocalDateTime publicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserJPAEntity usuario;
}
