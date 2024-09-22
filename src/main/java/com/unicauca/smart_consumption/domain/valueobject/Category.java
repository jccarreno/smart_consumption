package com.unicauca.smart_consumption.domain.valueobject;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Category {

    private final String categoryName;

    public Category(String categoryName) {
        if (!Objects.nonNull(categoryName) || categoryName.isEmpty()) {
            throw new IllegalArgumentException("The category categoryName cannot be null or empty");
        }
        this.categoryName = categoryName;
    }

}

