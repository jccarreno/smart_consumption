package com.unicauca.smart_consumption.infrastructure.embeddableEntity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class DetailEmbeddable {
    private  String description;
    private  String specifications;
}
