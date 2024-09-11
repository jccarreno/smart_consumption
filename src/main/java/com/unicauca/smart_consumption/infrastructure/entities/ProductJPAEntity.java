package com.unicauca.smart_consumption.infrastructure.entities;
import com.unicauca.smart_consumption.domain.model.valueObject.ProductStatus;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.CategoryEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.DetailEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.SustainabilityCriteriaEmbeddable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    private CategoryEmbeddable category;

    @Embedded
    private DetailEmbeddable detail;

    @Embedded
    private SustainabilityCriteriaEmbeddable sustainabilityCriteria;

    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.AVAILABLE;

    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ReviewJPAEntity> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<StoreJPAEntity> stores;
}
