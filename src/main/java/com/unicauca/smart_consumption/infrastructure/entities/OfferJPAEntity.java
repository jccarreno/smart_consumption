package com.unicauca.smart_consumption.infrastructure.entities;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.PeriodEmbeddable;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "offer")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OfferJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String detail;

    private double discountPercentage;

    private double discountedPrice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductJPAEntity product;
    @Embedded
    private PeriodEmbeddable period;
}
