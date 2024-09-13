package com.unicauca.smart_consumption.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
