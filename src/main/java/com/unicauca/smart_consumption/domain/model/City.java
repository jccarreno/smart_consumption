package com.unicauca.smart_consumption.domain.model;



import java.util.Objects;

public class City {
    private int id;
    private String name;
    private String department;

    public City(int id, String name, String department) {
        if (!Objects.nonNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (!Objects.nonNull(department)) {
            throw new IllegalArgumentException("department cannot be null.");
        }
        this.id = id;
        this.name = name;
        this.department = department;
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

    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        if (!Objects.nonNull(department)) {
            throw new IllegalArgumentException("department cannot be null.");
        }
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Objects.nonNull(o) || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                name.equals(city.name) &&
                department.equals(city.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
