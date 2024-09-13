package com.unicauca.smart_consumption.domain.model.valueobject;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Category {

    private final String name;
    public Category(String name) {
        if (!Objects.nonNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("The category name cannot be null or empty");
        }
        this.name = name;
    }

}

