package com.unicauca.smart_consumption.domain.model.valueobject;

import java.util.Objects;

public class Detail {
    private final String description;
    private final String specifications;

    public Detail(String description, String specifications) {
        if (!Objects.nonNull(description) || description.trim().isEmpty()) {
            throw new IllegalArgumentException("The description cannot be null or empty.");
        }
        this.description = description;
        this.specifications = specifications;
    }

    public String getDescription() {
        return description;
    }

    public String getSpecifications() {
        return specifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Objects.nonNull(o) || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(description, detail.description) &&
                Objects.equals(specifications, detail.specifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, specifications);
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Specifications: " + specifications;
    }
}
