package com.unicauca.smart_consumption.domain.model.valueObject;

import java.util.Objects;

public class Category {
    private final String name;

    public Category(String name) {
        if (!Objects.nonNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("The category name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Objects.nonNull(o) || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}

