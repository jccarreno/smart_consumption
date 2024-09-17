package com.unicauca.smart_consumption.infrastructure.user.dataproviders;

import com.unicauca.smart_consumption.infrastructure.city.dataproviders.CityJPAEntity;
import com.unicauca.smart_consumption.infrastructure.offer.dataproviders.OfferJPAEntity;
import com.unicauca.smart_consumption.infrastructure.review.dataproviders.ReviewJPAEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "user_app")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJPAEntity {

  @Id
  private String id;
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

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "city_id")
  private CityJPAEntity city;

  @PrePersist
  public void prePersist() {
    if (Objects.isNull(this.id)  || this.id.isEmpty()) {
      this.id = UUID.randomUUID().toString();
    }
  }

}
