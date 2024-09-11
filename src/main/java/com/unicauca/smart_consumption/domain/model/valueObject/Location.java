package com.unicauca.smart_consumption.domain.model.valueObject;

import java.util.Objects;

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

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Objects.nonNull(o) || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(address, location.address) &&
                Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, country);
    }

    @Override
    public String toString() {
        return address + ", " + country;
    }
}
