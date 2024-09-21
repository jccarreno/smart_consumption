package com.unicauca.smart_consumption.infrastructure.embeddableEntity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PeriodEmbeddable {
    private LocalDate startDate;
    private LocalDate endDate;
}
