package com.unicauca.smart_consumption.infrastructure.entities;
import jakarta.persistence.*;

import java.util.List;

import lombok.*;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StoreJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "store_product",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductJPAEntity> products;

    @OneToMany
    @JoinColumn(name = "offer_id")
    private List<OfferJPAEntity> offers;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityJPAEntitiy city;
}
