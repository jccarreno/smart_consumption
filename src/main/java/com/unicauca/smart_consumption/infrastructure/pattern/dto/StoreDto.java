package com.unicauca.smart_consumption.infrastructure.pattern.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StoreDto {
    private String name;
    private List<ProductMongoDto> products;
    private List<OfferDto> offers;
    private CityDto city;
}
