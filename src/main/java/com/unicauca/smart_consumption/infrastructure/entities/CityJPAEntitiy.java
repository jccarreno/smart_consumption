package com.unicauca.smart_consumption.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="city")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor

public class CityJPAEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String department;
}
