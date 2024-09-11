package com.unicauca.smart_consumption.infrastructure.embeddableEntity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class LocationEmbeddable {
    private String address;
    private String country;
}
