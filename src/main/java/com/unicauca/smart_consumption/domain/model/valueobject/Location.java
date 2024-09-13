package com.unicauca.smart_consumption.domain.model.valueobject;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Location {

    private final String address;
    private final String country;

    public Location(String address, String country) {
        if (!Objects.nonNull(address) || address.trim().isEmpty() || country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("The address, city, and country cannot be null or empty.");
        }
        this.address = address;

        this.country = country;
    }

}
