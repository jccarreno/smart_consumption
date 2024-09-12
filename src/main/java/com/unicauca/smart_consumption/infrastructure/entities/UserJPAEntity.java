package com.unicauca.smart_consumption.infrastructure.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "user_app")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "user_offer",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    private List<OfferJPAEntity> watchList;

    @ManyToMany
    @JoinTable(
            name = "user_review",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<ReviewJPAEntity> reviewList;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityJPAEntitiy city;

}
