package com.unicauca.smart_consumption.infrastructure.pattern.dto;

import com.unicauca.smart_consumption.domain.model.valueobject.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain to manage cen integration config.
 *
 * @author juliansmartinez@unicauca.edu.co
 * @version 1.0
 * @since 2024-09-13
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductMongoDto {
  private String name;
  private ProductStatus status;
  private double price;
}
