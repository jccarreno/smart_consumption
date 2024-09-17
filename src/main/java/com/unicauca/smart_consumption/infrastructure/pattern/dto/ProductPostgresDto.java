package com.unicauca.smart_consumption.infrastructure.pattern.dto;

import java.util.List;

import com.unicauca.smart_consumption.domain.review.Review;
import com.unicauca.smart_consumption.domain.store.Store;
import com.unicauca.smart_consumption.domain.valueobject.Category;
import com.unicauca.smart_consumption.domain.valueobject.Detail;
import com.unicauca.smart_consumption.domain.valueobject.ProductStatus;
import com.unicauca.smart_consumption.domain.valueobject.SustainabilityCriteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostgresDto {
  private String name;
  private CategoryDto category;
  private Detail detail;
  private SustainabilityCriteria sustainabilityCriteria;
  private ProductStatus status;
  private double price;
}
