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
public class UserDto {
    private String username;
    private String name;
    private List<ReviewDto> reviews;
    private List<OfferDto> watchList;
    private CityDto city;
}
