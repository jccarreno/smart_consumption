package com.unicauca.smart_consumption.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="city")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class CityJPAEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String department;
}
