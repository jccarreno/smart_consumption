package com.unicauca.smart_consumption.infrastructure.entities;

import com.unicauca.smart_consumption.infrastructure.embeddableEntity.PeriodEmbeddable;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql.ProductJpaEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "offer")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class OfferJPAEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String detail;
  private double discountPercentage;
  private double discountedPrice;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductJpaEntity product;
  @Embedded
  private PeriodEmbeddable period;
}
