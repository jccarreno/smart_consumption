package com.unicauca.smart_consumption.infrastructure.embeddableEntity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryEmbeddable {
    private  String categoryName;
}
