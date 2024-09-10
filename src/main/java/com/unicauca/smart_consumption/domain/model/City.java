package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.model.valueobject.Location;

import java.util.Objects;

public class City {
    private int id;
    private String name;
    private Location location;

    public City(int id, String name, Location location) {
        if (!Objects.nonNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (!Objects.nonNull(location)) {
            throw new IllegalArgumentException("Location cannot be null.");
        }
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Objects.nonNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if (!Objects.nonNull(location)) {
            throw new IllegalArgumentException("Location cannot be null.");
        }
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                name.equals(city.name) &&
                location.equals(city.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
