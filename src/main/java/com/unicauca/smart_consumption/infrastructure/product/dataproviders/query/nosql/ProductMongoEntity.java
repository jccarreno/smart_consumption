package com.unicauca.smart_consumption.infrastructure.product.dataproviders.query.nosql;

import com.unicauca.smart_consumption.domain.valueobject.ProductStatus;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.CategoryEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.DetailEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.SustainabilityCriteriaEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB document representation of the product.
 */
@Document(collection = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMongoEntity {
  @Id
  private String id;
  private String name;
  private double price;
  private CategoryEmbeddable category;
  private DetailEmbeddable detail;
  private SustainabilityCriteriaEmbeddable sustainabilityCriteria;
  private ProductStatus status;
}
