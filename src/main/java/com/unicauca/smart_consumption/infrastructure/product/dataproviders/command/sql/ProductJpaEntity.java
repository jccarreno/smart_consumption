package com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql;

import com.unicauca.smart_consumption.domain.valueobject.ProductStatus;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.CategoryEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.DetailEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.SustainabilityCriteriaEmbeddable;
import com.unicauca.smart_consumption.infrastructure.review.dataproviders.ReviewJPAEntity;
import com.unicauca.smart_consumption.infrastructure.store.dataproviders.StoreJPAEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductJpaEntity {
    @Id
    private String id;

    private String name;
    @Embedded
    private CategoryEmbeddable category;

    @Embedded
    private DetailEmbeddable detail;

    @Embedded
    private SustainabilityCriteriaEmbeddable sustainabilityCriteria;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ReviewJPAEntity> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<StoreJPAEntity> stores;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.id)  || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
