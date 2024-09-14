package com.unicauca.smart_consumption.infrastructure.city.dataproviders;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="city")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class CityJPAEntitiy {
    @Id
    private String id;

    private String name;

    private String department;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.id)  || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
