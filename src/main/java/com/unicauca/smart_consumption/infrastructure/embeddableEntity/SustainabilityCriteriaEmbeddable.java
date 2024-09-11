package com.unicauca.smart_consumption.infrastructure.embeddableEntity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SustainabilityCriteriaEmbeddable {
    private double carbonFootprint;
    private double energyEfficiency;
    private double resourceUsage;
    private double wasteManagement;
    private double sustainabilityScore;
}
