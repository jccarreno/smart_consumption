package com.unicauca.smart_consumption.infrastructure.pattern.dto;

import com.unicauca.smart_consumption.infrastructure.embeddableEntity.PeriodEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OfferDto {
    private String description;
    private ProductMongoDto productDto;
    private PeriodEmbeddable periodDto;
    private double discountPercentage;
    private double discountedPrice;
}
