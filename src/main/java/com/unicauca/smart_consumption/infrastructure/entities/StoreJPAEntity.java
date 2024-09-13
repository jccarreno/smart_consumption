package com.unicauca.smart_consumption.infrastructure.entities;

import com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql.ProductJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StoreJPAEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "store_product",
      joinColumns = @JoinColumn(name = "store_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<ProductJpaEntity> products;

  @OneToMany
  @JoinColumn(name = "offer_id")
  private List<OfferJPAEntity> offers;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private CityJPAEntitiy city;
}
