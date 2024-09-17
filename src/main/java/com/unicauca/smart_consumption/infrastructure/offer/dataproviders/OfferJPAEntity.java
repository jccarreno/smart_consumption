package com.unicauca.smart_consumption.infrastructure.offer.dataproviders;

import com.unicauca.smart_consumption.infrastructure.embeddableEntity.PeriodEmbeddable;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql.ProductJpaEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "offer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OfferJPAEntity {
  @Id
  private String id;
  private String detail;
  private double discountPercentage;
  private double discountedPrice;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductJpaEntity product;
  @Embedded
  private PeriodEmbeddable period;
  @PrePersist
  public void prePersist() {
    if (Objects.isNull(this.id)  || this.id.isEmpty()) {
      this.id = UUID.randomUUID().toString();
    }
  }
}
