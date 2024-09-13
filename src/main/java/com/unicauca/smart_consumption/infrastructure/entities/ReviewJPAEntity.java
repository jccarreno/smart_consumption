package com.unicauca.smart_consumption.infrastructure.entities;

import com.unicauca.smart_consumption.domain.model.valueobject.Rating;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql.ProductJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewJPAEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String comment;

  private LocalDateTime datePublication;

  @Enumerated(EnumType.STRING)
  private Rating rating;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private ProductJpaEntity product;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserJPAEntity user;
}
