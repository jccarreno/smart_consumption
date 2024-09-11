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
@NoArgsConstructor
public class OfferJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String detail;
    @NonNull
    private double discountPercentage;
    @NonNull
    private double discountedPrice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductJPAEntity product;
    @Embedded
    private PeriodEmbeddable period;
}
